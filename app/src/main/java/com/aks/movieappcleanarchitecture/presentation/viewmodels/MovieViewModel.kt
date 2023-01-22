package com.aks.movieappcleanarchitecture.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aks.movieappcleanarchitecture.data.resource.NetworkResource
import com.aks.movieappcleanarchitecture.domain.usecases.GetBreakingNewsUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetNowplayingMovieUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetTopRatedMovieUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class MovieViewModel(
    private val getTopRatedMovieUseCases: GetTopRatedMovieUseCases,
    private val getNowplayingMovieUseCases: GetNowplayingMovieUseCases,
    private val getBreakingNewsUseCases: GetBreakingNewsUseCases
) : ViewModel() {

    val getTopRatedMovie: MutableLiveData<NetworkResource<ResponseBody>> = MutableLiveData()
    val getNowPlayingMovie: MutableLiveData<NetworkResource<ResponseBody>> = MutableLiveData()
    val getBreakingNews: MutableLiveData<NetworkResource<ResponseBody>> = MutableLiveData()

    init {
        viewModelScope.launch {
            getTopRatedMovieUseCases.execute(1)
        }
    }

    fun getTopRatedMovie(pageNum: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getTopRatedMovie.postValue(NetworkResource.Loading())
                getTopRatedMovie.postValue(getTopRatedMovieUseCases.execute(pageNum))
            } catch (e: Exception) {
                getTopRatedMovie.postValue(NetworkResource.Error(e.message.toString()))
            }
        }
    }

    fun getNowPlayingMovie(pageNum: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getNowPlayingMovie.postValue(NetworkResource.Loading())
                getNowPlayingMovie.postValue(getNowplayingMovieUseCases.execute(pageNum))
            }catch (e : Exception){
                e.printStackTrace()
                getNowPlayingMovie.postValue(NetworkResource.Error(e.message.toString()))
            }
        }
    }

    fun getBreakingNews(pageNum: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getBreakingNews.postValue(NetworkResource.Loading())
                getBreakingNews.postValue(getBreakingNewsUseCases.execute(pageNum))
            }catch (e : Exception){
                e.printStackTrace()
                getBreakingNews.postValue(NetworkResource.Error(e.message.toString()))
            }
        }
    }
}