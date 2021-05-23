package com.example.esiea_3a.presentation

import android.app.Application
import android.content.Context

class AnimeApplication : Application() {
    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}