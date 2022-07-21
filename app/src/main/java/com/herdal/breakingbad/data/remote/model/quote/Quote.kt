package com.herdal.breakingbad.data.remote.model.quote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quote(
    val author: String,
    val quote: String,
    val quote_id: Int,
    val series: String
) : Parcelable