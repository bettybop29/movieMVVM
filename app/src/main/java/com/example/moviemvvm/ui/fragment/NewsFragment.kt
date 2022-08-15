package com.example.moviemvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemvvm.R
import com.example.moviemvvm.databinding.ActivityListNewsBinding
import com.example.moviemvvm.ui.adapter.NewsAdapter
import com.example.moviemvvm.ui.viewmodel.ListNewsViewModel
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [newsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class newsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: ListNewsViewModel by viewModels()
    lateinit var binding: ActivityListNewsBinding
    lateinit var adapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ActivityListNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        binding.listNews.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getListNews("tesla")
        val button: Button = binding.btnNewsApple
        button.setOnClickListener {
            viewModel.getListNews("apple")
            Snackbar.make(binding.listNews, "apple", Snackbar.LENGTH_SHORT).show()
        }
        val buttons: Button = binding.btnNewsTesla
        buttons.setOnClickListener {
            viewModel.getListNews("tesla")
            Snackbar.make(binding.btnNewsTesla, "tesla", Snackbar.LENGTH_SHORT).show()

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment newsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            newsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setObserver() {
        viewModel.getNews().observe(requireActivity(), Observer {
            Log.e("list news fragment", "response=$it")
            adapter = NewsAdapter(it.articles)
            binding.listNews.adapter = adapter
        })
    }
}