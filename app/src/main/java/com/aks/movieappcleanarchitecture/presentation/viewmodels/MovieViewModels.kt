package com.aks.movieappcleanarchitecture.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aks.movieappcleanarchitecture.data.repo.resource.NetworkResource
import com.aks.movieappcleanarchitecture.domain.usecases.GetBreakingNewsUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetNowPlayingMovieUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetTopRatedMovieUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class MovieViewModels(
    private val getTopRatedMovieUseCases: GetTopRatedMovieUseCases,
    private val getNowPlayingMovieUseCases: GetNowPlayingMovieUseCases,
    private val getBreakingNewsUseCases: GetBreakingNewsUseCases
) : ViewModel() {


    val getTopRatedMovie: MutableLiveData<NetworkResource<ResponseBody>> = MutableLiveData()
    val getNowPlayingMovie: MutableLiveData<NetworkResource<ResponseBody>> = MutableLiveData()
    val getBreakingNews: MutableLiveData<NetworkResource<ResponseBody>> = MutableLiveData()


    fun getNowPlayingMovie(pageNum: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                getNowPlayingMovie.postValue(NetworkResource.Loading())
                getNowPlayingMovie.postValue(getNowPlayingMovieUseCases.execute(pageNum))
            }
        } catch (e: Exception) {
            getNowPlayingMovie.postValue(NetworkResource.Error(e.message.toString()))
        }
    }

    fun getTopRatedMovie(pageNum: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                getTopRatedMovie.postValue(NetworkResource.Loading())
                getTopRatedMovie.postValue(getTopRatedMovieUseCases.execute(pageNum))
            }
        } catch (e: Exception) {
            getTopRatedMovie.postValue(NetworkResource.Error(e.message.toString()))
        }
    }

    fun getBreakingNews(pageNum: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                getBreakingNews.postValue(NetworkResource.Loading())
                getBreakingNews.postValue(getBreakingNewsUseCases.execute(pageNum))
            }
        } catch (e: Exception) {
            getBreakingNews.postValue(NetworkResource.Error(e.message.toString()))
        }
    }
}