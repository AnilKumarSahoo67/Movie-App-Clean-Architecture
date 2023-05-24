package com.aks.movieappcleanarchitecture.presentation.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aks.movieappcleanarchitecture.R
import com.aks.movieappcleanarchitecture.data.model.ResponseCheckingModel
import com.aks.movieappcleanarchitecture.data.repo.resource.NetworkResource
import com.aks.movieappcleanarchitecture.databinding.ActivityMainBinding
import com.aks.movieappcleanarchitecture.presentation.base.adapter.BreakingNewsAdapter
import com.aks.movieappcleanarchitecture.presentation.base.adapter.NowPlayingAdapter
import com.aks.movieappcleanarchitecture.presentation.base.adapter.TopRatedAdapter
import com.aks.movieappcleanarchitecture.presentation.viewmodels.MovieViewModelFactory
import com.aks.movieappcleanarchitecture.presentation.viewmodels.MovieViewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory

    @Inject
    lateinit var topRatedAdapter: TopRatedAdapter

    @Inject
    lateinit var nowPlayingAdapter: NowPlayingAdapter

    @Inject
    lateinit var breakingNewsAdapter: BreakingNewsAdapter

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModels: MovieViewModels
    private var breakingNewsResponse: Boolean = false
    private var topRatedMovieResponse: Boolean = false
    private var nowPlayingMovieResponse: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModels = ViewModelProvider(this, viewModelFactory)[MovieViewModels::class.java]
        supportActionBar?.hide()


        binding.recyclerBanner.adapter = breakingNewsAdapter
        binding.recyclerNowPlaying.adapter = nowPlayingAdapter
        binding.recyclerTopRated.adapter = topRatedAdapter


        CoroutineScope(Dispatchers.IO).launch {
            viewModels.getTopRatedMovie(1)
        }

        CoroutineScope(Dispatchers.IO).launch {
            viewModels.getNowPlayingMovie(1)
        }
        CoroutineScope(Dispatchers.IO).launch {
            viewModels.getBreakingNews(1)
        }


        viewModels.movieResponse.observe(this) {
            if (viewModels.movieResponse.value?.breakingNewsResponse == true) {
                breakingNewsResponse = true
            }
            if (viewModels.movieResponse.value?.topRatedMovieResponse == true) {
                topRatedMovieResponse = true
            }
            if (viewModels.movieResponse.value?.nowPlayingMovieResponse == true) {
                nowPlayingMovieResponse = true
            }

            if (breakingNewsResponse && topRatedMovieResponse && nowPlayingMovieResponse) {
                binding.relativeLayout.visibility = View.GONE

            } else {
                binding.relativeLayout.visibility = View.VISIBLE
            }
        }

        /*
                viewModels.movieResponse.observe(this){
                    if (viewModels.getBreakingNewsResponse.value == true
                        && viewModels.getNowPlayingMovieResponse.value == true
                        && viewModels.getTopRatedMovieResponse.value == true) {

                        binding.relativeLayout.visibility = View.GONE

                    } else {
                        binding.relativeLayout.visibility = View.VISIBLE
                    }
                }*/

        nowPlayingAdapter.onItemClickCallBack { results, i ->
            Toast.makeText(this,results.title,Toast.LENGTH_SHORT).show()
        }
        topRatedAdapter.onItemClickCallBack { results, i ->
            Toast.makeText(this,results.title,Toast.LENGTH_SHORT).show()
        }
        breakingNewsAdapter.onItemClickCallBack { articles, i ->
            Toast.makeText(this,articles.title,Toast.LENGTH_SHORT).show()
        }



        viewModels.getTopRatedMovie.observe(this) {
            when (it) {
                is NetworkResource.Loading -> {

                }

                is NetworkResource.Success -> {
                    viewModels.getTopRatedMovieResponse.value = true
                    viewModels.movieResponse.value =
                        ResponseCheckingModel(topRatedMovieResponse = true)
                    it.data?.let { response ->
                        topRatedAdapter.differ.submitList(response.results)
                    }
                }

                is NetworkResource.Error -> {
                    Toast.makeText(this, "Error getting Top rated movie", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModels.getBreakingNews.observe(this) {
            when (it) {
                is NetworkResource.Loading -> {

                }

                is NetworkResource.Success -> {
                    viewModels.getBreakingNewsResponse.value = true
                    viewModels.movieResponse.value =
                        ResponseCheckingModel(breakingNewsResponse = true)
                    it.data?.let { response ->
                        breakingNewsAdapter.differ.submitList(response.articles)
                    }
                }

                is NetworkResource.Error -> {
                    Toast.makeText(this, "Error getting Now playing movie", Toast.LENGTH_SHORT)
                        .show()

                }
            }
        }

        viewModels.getNowPlayingMovie.observe(this) {
            when (it) {
                is NetworkResource.Loading -> {

                }

                is NetworkResource.Success -> {
                    viewModels.getNowPlayingMovieResponse.value = true
                    viewModels.movieResponse.value =
                        ResponseCheckingModel(nowPlayingMovieResponse = true)

                    it.data?.let { response ->
                        nowPlayingAdapter.differ.submitList(response.results)
                    }
                }

                is NetworkResource.Error -> {
                    Toast.makeText(this, "Error getting Top rated movie", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }
}