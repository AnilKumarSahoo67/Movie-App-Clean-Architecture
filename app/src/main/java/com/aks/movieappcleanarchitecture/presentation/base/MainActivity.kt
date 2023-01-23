package com.aks.movieappcleanarchitecture.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aks.movieappcleanarchitecture.R
import com.aks.movieappcleanarchitecture.data.repo.resource.NetworkResource
import com.aks.movieappcleanarchitecture.presentation.viewmodels.MovieViewModelFactory
import com.aks.movieappcleanarchitecture.presentation.viewmodels.MovieViewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory
    private lateinit var viewModels: MovieViewModels
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModels = ViewModelProvider(this, viewModelFactory)[MovieViewModels::class.java]


        viewModels.getTopRatedMovie(1)

        viewModels.getTopRatedMovie.observe(this) {
            when (it) {
                is NetworkResource.Loading -> {

                }
                is NetworkResource.Success -> {

                }
                is NetworkResource.Error -> {

                }
                else -> {}
            }
        }

    }
}