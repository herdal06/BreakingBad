package com.herdal.breakingbad.domain.model.quote

data class Quote(
    val author: String,
    val quote: String,
    val quote_id: Int,
    val series: String
)