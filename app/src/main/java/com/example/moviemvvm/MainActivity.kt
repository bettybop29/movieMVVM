package com.example.moviemvvm
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moviemvvm.databinding.ActivityMainBinding
import com.example.moviemvvm.ui.fragment.moviesFragment
import com.example.moviemvvm.ui.fragment.newsFragment



class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val news = newsFragment()
    private val movies = moviesFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomnavigation.background = null
//        binding.btnListMovie.setOnClickListener {
//            val intent = Intent(this, ListMovieActivity::class.java)
//            startActivity(intent)
//        }
//        binding.btnNowPlayingMovie.setOnClickListener {
//            val intent = Intent(this, ListNowPlayingActivity::class.java)
//            startActivity(intent)
//        }
//        binding.btnTrailerMovie.setOnClickListener {
//            val i = Intent(this, ListNewsActivity::class.java)
//            startActivity(i)
//        }
        replaceFragment(news)
        binding.bottomnavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.icMovies -> replaceFragment(movies)
                R.id.icNews -> replaceFragment(news)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameContainer, fragment)
            transaction.commit()

    }

}