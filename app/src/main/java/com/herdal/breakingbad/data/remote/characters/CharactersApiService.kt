package com.herdal.breakingbad.data.remote.characters

import com.herdal.breakingbad.core.ApiConstants
import com.herdal.breakingbad.domain.model.character.Character
import retrofit2.http.GET

interface CharactersApiService {
    @GET(ApiConstants.Endpoint.CHARACTERS)
    suspend fun getAllCharacters(): List<Character>
}