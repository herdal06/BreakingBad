package com.herdal.breakingbad.di

import com.herdal.breakingbad.data.remote.episodes.EpisodesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideEpisodesApiService(retrofit: Retrofit): EpisodesApiService {
        return retrofit.create()
    }
}