package com.cbpark.travelbudgetmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.cbpark.travel.viewmodel.TravelViewModel
import com.cbpark.travelbudgetmanager.ui.page.TravelPage
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  private val travelViewModel by viewModels<TravelViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      TravelBudgetManagerTheme {
        TravelPage(
          travelViewModel = travelViewModel
        )
      }
    }
  }
}