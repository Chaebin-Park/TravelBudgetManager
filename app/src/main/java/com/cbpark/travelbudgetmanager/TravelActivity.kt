package com.cbpark.travelbudgetmanager

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.cbpark.travel.entity.Travel
import com.cbpark.travel.viewmodel.SearchTravelViewModel
import com.cbpark.travel.viewmodel.TravelViewModel
import com.cbpark.travelbudgetmanager.ui.page.TravelPage
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TravelActivity : ComponentActivity() {
  private val travelViewModel by viewModels<SearchTravelViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    val intentTravelId = intent.getIntExtra("travel_id", -1)
    travelViewModel.findTravelById(intentTravelId)

    setContent {
      TravelBudgetManagerTheme {
        TravelPage(
          searchTravelViewModel = travelViewModel
        )
      }
    }
  }
}