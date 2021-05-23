package com.example.esiea_3a.presentation

import com.example.esiea_3a.presentation.AnimeApplication.Companion.context
import com.example.esiea_3a.presentation.api.JikanApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class SingletonAPI {
   companion object {

       var cache = Cache(File(context?.cacheDir,"responses"), 20*1024*1024)

       val okhttpclient: OkHttpClient = OkHttpClient().newBuilder()
           .cache(cache)
           .build()

       val jikanApi: JikanApi = Retrofit.Builder()
           .baseUrl("https://api.jikan.moe/v3/")
           .addConverterFactory(GsonConverterFactory.create())
           .client(okhttpclient)
           .build()
           .create(JikanApi::class.java)
    }

}