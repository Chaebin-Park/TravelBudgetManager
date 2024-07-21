package com.cbpark.travelbudgetmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cbpark.travel.entities.CountryCode
import com.cbpark.travel.entities.Travel
import com.cbpark.travel.viewmodel.TravelViewModel
import com.cbpark.travelbudgetmanager.ui.component.TopBar
import com.cbpark.travelbudgetmanager.ui.component.button.PrimaryIconButton
import com.cbpark.travelbudgetmanager.ui.page.TravelPage
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

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