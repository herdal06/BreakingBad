package com.herdal.breakingbad.domain.model.episode

data class EpisodeItem(
    val air_date: String,
    val characters: List<String>,
    val episode: String,
    val episode_id: Int,
    val season: String,
    val series: String,
    val title: String
)