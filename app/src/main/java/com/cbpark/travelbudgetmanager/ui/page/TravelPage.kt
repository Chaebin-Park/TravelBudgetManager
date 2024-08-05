package com.cbpark.travelbudgetmanager.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cbpark.travel.entity.Travel

@Composable
fun TravelPage(travel: Travel) {
  Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    Text(text = "Travel ID: ${travel.id}", modifier = Modifier.padding(bottom = 8.dp))
    Text(text = "Name: ${travel.name}", modifier = Modifier.padding(bottom = 8.dp))
    Text(text = "Currency: ${travel.currency}", modifier = Modifier.padding(bottom = 8.dp))
  }
}