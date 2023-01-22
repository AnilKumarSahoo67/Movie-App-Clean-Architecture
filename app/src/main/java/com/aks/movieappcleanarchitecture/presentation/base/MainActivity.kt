package com.aks.movieappcleanarchitecture.presentation.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aks.movieappcleanarchitecture.R
import com.aks.movieappcleanarchitecture.presentation.viewmodels.MovieViewModel
import com.aks.movieappcleanarchitecture.presentation.viewmodels.MovieViewModelProviderFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelProviderFactory: MovieViewModelProviderFactory

    lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =
            ViewModelProvider(this, movieViewModelProviderFactory)[MovieViewModel::class.java]

        viewModel.getTopRatedMovie(1)
        viewModel.getBreakingNews(1)
        viewModel.getNowPlayingMovie(1)
    }
}