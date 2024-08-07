package com.cbpark.ui.button


import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TestButton(modifier: Modifier = Modifier) {
  Button(
    onClick = {}
  ) {
    Text(text = "Test Button")
  }
}