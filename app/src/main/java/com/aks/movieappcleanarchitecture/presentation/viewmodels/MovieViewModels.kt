package com.aks.movieappcleanarchitecture.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aks.movieappcleanarchitecture.data.model.GetBreakingNewsResponse
import com.aks.movieappcleanarchitecture.data.model.GetNowPlayingMovieResponse
import com.aks.movieappcleanarchitecture.data.model.GetTopRatedMovieResponse
import com.aks.movieappcleanarchitecture.data.model.ResponseCheckingModel
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

    val movieResponse : MutableLiveData<ResponseCheckingModel> = MutableLiveData()
    val getTopRatedMovieResponse = MutableLiveData<Boolean>()
    val getNowPlayingMovieResponse = MutableLiveData<Boolean>()
    val getBreakingNewsResponse = MutableLiveData<Boolean>()


    val getTopRatedMovie: MutableLiveData<NetworkResource<GetTopRatedMovieResponse>> = MutableLiveData()
    val getNowPlayingMovie: MutableLiveData<NetworkResource<GetNowPlayingMovieResponse>> = MutableLiveData()
    val getBreakingNews: MutableLiveData<NetworkResource<GetBreakingNewsResponse>> = MutableLiveData()


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