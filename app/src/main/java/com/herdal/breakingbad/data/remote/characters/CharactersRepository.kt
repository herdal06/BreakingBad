package com.herdal.breakingbad.data.remote.characters

import javax.inject.Inject

class CharactersRepository @Inject constructor(private val apiService: CharactersApiService) {
    suspend fun getAllCharacters() = apiService.getAllCharacters()
}