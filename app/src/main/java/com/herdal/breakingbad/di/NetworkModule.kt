package com.herdal.breakingbad.di

import com.herdal.breakingbad.data.remote.characters.ApiService
import com.herdal.breakingbad.utils.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCharacterService(): ApiService =
        Retrofit.Builder().baseUrl(ApiConstants.Endpoint.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        )
            .build().create(ApiService::class.java)

}