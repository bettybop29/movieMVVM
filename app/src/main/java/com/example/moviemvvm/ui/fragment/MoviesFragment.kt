package com.example.moviemvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemvvm.R
import com.example.moviemvvm.data.vo.ResultX
import com.example.moviemvvm.databinding.ActivityListMovieBinding
import com.example.moviemvvm.databinding.ActivityListNowPlayingBinding
import com.example.moviemvvm.ui.ListNowPlayingActivity
import com.example.moviemvvm.ui.adapter.MovieAdapter
import com.example.moviemvvm.ui.viewmodel.ListMovieViewModel
import com.example.moviemvvm.ui.viewmodel.ListNowMoviesViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [moviesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class moviesFragment : Fragment() {
    // TODO: Rename and change types of parameters isi variabel
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: ListMovieViewModel by viewModels()
    lateinit var binding: ActivityListMovieBinding
    lateinit var adapter: MovieAdapter

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
        // Inflate the layout for this fragment\
        binding = ActivityListMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        binding.listMovie.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getPopularMovies()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment moviesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            moviesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setObserver() {
        viewModel.getMovies().observe(requireActivity(), Observer {
            adapter = MovieAdapter(it.results)
            binding.listMovie.adapter = adapter

        })
    }
}