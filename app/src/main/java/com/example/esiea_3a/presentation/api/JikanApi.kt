package com.example.esiea_3a.presentation.api

import retrofit2.Call
import retrofit2.http.GET

interface JikanApi {
    @GET("season/2021/spring")
    fun getCurrentSeasonals(): Call<JikanSeasonalResponse>
}