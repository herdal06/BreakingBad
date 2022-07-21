package com.herdal.breakingbad.data.remote.model.episode

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Episode(
    val air_date: String,
    val characters: List<String>,
    val episode: String,
    val episode_id: Int,
    val season: String,
    val series: String,
    val title: String
) : Parcelable