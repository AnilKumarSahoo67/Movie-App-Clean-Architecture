package com.aks.movieappcleanarchitecture.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.Before
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
internal class MovieViewModelTest : TestCase(){
    private lateinit var viewModel: MovieViewModel
    @Inject
    lateinit var movieViewModelProviderFactory : MovieViewModelProviderFactory

    @Before
    override fun setUp() {
        super.setUp()
        val context  = ApplicationProvider.getApplicationContext<Context>()
    }
}