package com.cbpark.travelbudgetmanager.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cbpark.travelbudgetmanager.ui.component.TopBar

@Composable
fun TravelPage(modifier: Modifier = Modifier) {
  Scaffold (
    topBar = { TopBar() }
  ) { paddingValue ->
    Box(modifier = Modifier.padding(paddingValue)) {

    }
  }
}

fun TravelPage() {

}