package com.cbpark.travelbudgetmanager.ui.component.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme
import com.cbpark.travelbudgetmanager.ui.theme.underlinedButton

@Composable
fun UnderlinedText(
  modifier: Modifier = Modifier,
  @StringRes id: Int? = null,
  text: String = ""
) {
  Column {
    Text(
      modifier = modifier,
      text = id?.let { stringResource(id = id) } ?: text,
      style = MaterialTheme.typography.underlinedButton,
    )
  }
}

@Preview
@Composable
private fun UnderlinedTextPrev() {
  TravelBudgetManagerTheme {
    UnderlinedText(
      text = "Underline"
    )
  }
}