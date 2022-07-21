package com.herdal.breakingbad.di

import com.herdal.breakingbad.data.remote.characters.CharactersApiService
import com.herdal.breakingbad.utils.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCharacterService(): CharactersApiService =
        Retrofit.Builder().baseUrl(ApiConstants.Endpoint.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        )
            .build().create(CharactersApiService::class.java)

}