package com.cbpark.travelbudgetmanager

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
  companion object {
    lateinit var INSTANCE: App
  }

  init {
    INSTANCE = this
  }
}