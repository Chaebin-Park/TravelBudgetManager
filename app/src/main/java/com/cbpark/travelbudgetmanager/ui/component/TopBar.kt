package com.cbpark.travelbudgetmanager.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cbpark.ui.text.TitleText
import com.cbpark.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
  navigationIcon: @Composable () -> Unit = {},
  optionalIcon: @Composable () -> Unit = {}
) {
  TopAppBar(
    modifier = Modifier
      .background(color = Color.White)
      .fillMaxWidth(),
    navigationIcon = navigationIcon,
    title = {
      Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        TitleText(text = "Travel Wallet")
        optionalIcon()
      }
    },
  )
}

@Preview
@Composable
private fun TopBarPrev2() {
  CustomTheme {
    TopBar(
      optionalIcon = {
        Row {
          IconButton(onClick = {  }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Add icon")
          }
          IconButton(onClick = {  }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
          }
        }
      }
    )
  }
}


@Preview
@Composable
private fun TopBarPrev() {
  CustomTheme {
    TopBar(
      optionalIcon = {
        IconButton(onClick = {  }) {
          Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
        }
      }
    )
  }
}

@Preview
@Composable
private fun TopBarPrev3() {
  CustomTheme {
    TopBar(
      navigationIcon = {
        IconButton(onClick = {  }) {
          Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
        }
      },
      optionalIcon = {
        IconButton(onClick = {  }) {
          Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
        }
      }
    )
  }
}

