package com.aks.movieappcleanarchitecture.presentation.di.repository

import com.aks.movieappcleanarchitecture.data.repo.datasource.RemoteDataSource
import com.aks.movieappcleanarchitecture.data.repo.repositoryimpl.RepositoryImpl
import com.aks.movieappcleanarchitecture.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositoryModule (remoteDataSource: RemoteDataSource) : Repository{
        return RepositoryImpl(remoteDataSource)
    }
}