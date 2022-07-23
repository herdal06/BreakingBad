package com.herdal.breakingbad.data.remote.characters

import javax.inject.Inject

class CharactersRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllCharacters() = apiService.getAllCharacters()
    suspend fun getAllEpisodes() = apiService.getAllEpisodes()
}