package com.herdal.breakingbad.data.remote.characters

import com.herdal.breakingbad.utils.ApiConstants
import com.herdal.breakingbad.data.remote.model.character.Character
import com.herdal.breakingbad.data.remote.model.episode.Episode
import retrofit2.Response
import retrofit2.http.GET

interface CharactersApiService {
    @GET(ApiConstants.Endpoint.CHARACTERS)
    suspend fun getAllCharacters(): Response<List<Character>>

    @GET(ApiConstants.Endpoint.EPISODES)
    suspend fun getAllEpisodes(): Response<List<Episode>>
}