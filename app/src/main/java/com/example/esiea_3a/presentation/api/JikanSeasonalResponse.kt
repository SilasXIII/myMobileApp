package com.example.esiea_3a.presentation.api

import com.example.esiea_3a.presentation.list.Anime

data class JikanSeasonalResponse(
    val season_name: String,
    val season_year: Int,
    val anime: List<Anime>
)