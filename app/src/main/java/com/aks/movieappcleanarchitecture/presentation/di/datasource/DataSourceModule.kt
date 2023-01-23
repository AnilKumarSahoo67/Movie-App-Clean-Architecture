package com.aks.movieappcleanarchitecture.presentation.di.datasource

import com.aks.movieappcleanarchitecture.data.MovieApis
import com.aks.movieappcleanarchitecture.data.repo.dataSouceImpl.RemoteDataSourceImpl
import com.aks.movieappcleanarchitecture.data.repo.datasource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSourceModule(movieApis: MovieApis) : RemoteDataSource{
        return RemoteDataSourceImpl(movieApis)
    }
}