package com.aks.movieappcleanarchitecture.data.repo.repositoryimpl

import com.aks.movieappcleanarchitecture.data.repo.datasource.RemoteDataSource
import com.aks.movieappcleanarchitecture.data.repo.resource.NetworkResource
import com.aks.movieappcleanarchitecture.domain.repository.Repository
import okhttp3.ResponseBody
import retrofit2.Response

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository{
    override suspend fun getTopRatedMovie(pageNum: Int): NetworkResource<ResponseBody> {
        return responseToResource(remoteDataSource.getTopRatedMovie(pageNum))
    }

    override suspend fun getNowPlayingMovie(pageNum: Int): NetworkResource<ResponseBody> {
        return responseToResource((remoteDataSource.getNowPlayingMovie(pageNum)))
    }

    override suspend fun getBreakingNews(pageNum: Int): NetworkResource<ResponseBody> {
        return responseToResource(remoteDataSource.getBreakingNews(pageNum))
    }
    private fun <T> responseToResource(response : Response<T>) : NetworkResource<T>{
        if (response.isSuccessful){
            response.body()?.let {
                return NetworkResource.Success(it)
            }
        }
        return NetworkResource.Error(response.code().toString()+" Error")
    }
}