package com.cbpark.travelbudgetmanager.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cbpark.travel.entity.Travel
import com.cbpark.travel.viewmodel.SearchTravelViewModel
import com.cbpark.travelbudgetmanager.ui.component.TopBar
import com.cbpark.travelbudgetmanager.ui.component.text.TitleText

@Composable
fun TravelPage(
  modifier: Modifier = Modifier,
  searchTravelViewModel: SearchTravelViewModel = hiltViewModel()
) {
  val travel by searchTravelViewModel.travel.collectAsState()

  Scaffold (
    topBar = { TopBar() }
  ) { paddingValue ->
    Box(modifier = Modifier.padding(paddingValue)) {
      travel?.let {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
          Text(text = "Travel ID: ${it.id}", modifier = Modifier.padding(bottom = 8.dp))
          Text(text = "Name: ${it.name}", modifier = Modifier.padding(bottom = 8.dp))
          Text(text = "Currency: ${it.currency}", modifier = Modifier.padding(bottom = 8.dp))
        }
      } ?: run {
        // 여행 정보가 로드되지 않은 경우에 대한 UI
        Text(text = "Loading...", modifier = Modifier.fillMaxSize().padding(16.dp))
      }
    }
  }
}

fun TravelPage() {

}