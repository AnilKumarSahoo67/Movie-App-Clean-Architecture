package com.aks.movieappcleanarchitecture.presentation.di.adapter

import com.aks.movieappcleanarchitecture.presentation.base.adapter.BreakingNewsAdapter
import com.aks.movieappcleanarchitecture.presentation.base.adapter.NowPlayingAdapter
import com.aks.movieappcleanarchitecture.presentation.base.adapter.TopRatedAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideBreakingNewsAdapter() : BreakingNewsAdapter{
        return BreakingNewsAdapter()
    }

    @Provides
    @Singleton
    fun provideNowPlayingAdapter() : NowPlayingAdapter{
        return NowPlayingAdapter()
    }

    @Provides
    @Singleton
    fun provideTopRatedAdapter() : TopRatedAdapter{
        return TopRatedAdapter()
    }
}