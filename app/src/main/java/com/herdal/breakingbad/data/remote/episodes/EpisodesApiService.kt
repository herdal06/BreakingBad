package com.herdal.breakingbad.data.remote.episodes

import com.herdal.breakingbad.core.ApiConstants
import com.herdal.breakingbad.domain.model.episode.Episode
import retrofit2.http.GET

interface EpisodesApiService {
    @GET(ApiConstants.Endpoint.EPISODES)
    suspend fun getAllEpisodes(): List<Episode>
}