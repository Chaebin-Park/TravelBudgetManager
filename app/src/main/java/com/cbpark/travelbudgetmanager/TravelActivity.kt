package com.cbpark.travelbudgetmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cbpark.travel.viewmodel.SearchTravelViewModel
import com.cbpark.travelbudgetmanager.ui.component.TopBar
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
        Scaffold (
          topBar = { TopBar(
            navigationIcon = {
              IconButton(onClick = { finish() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Add icon")
              }
            }
          ) }
        ) { paddingValue ->
          val travel by travelViewModel.travel.collectAsState()

          Box(modifier = Modifier.padding(paddingValue)) {
            travel?.let {
              TravelPage(it)
            } ?: run {
              Text(text = "Loading...", modifier = Modifier.fillMaxSize().padding(16.dp))
            }
          }
        }
      }
    }
  }
}