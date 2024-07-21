package com.cbpark.travelbudgetmanager.ui.component.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.cbpark.travelbudgetmanager.ui.theme.MyTypography
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme

@Composable
fun PrimaryText(
  modifier: Modifier = Modifier,
  @StringRes id: Int? = null,
  text: String = ""
) {
    Text(
      modifier = modifier,
      text = id?.let { stringResource(id = id) } ?: text,
      style = MyTypography.labelMedium,
      textAlign = TextAlign.Center,
      fontSize = TextUnit(20f, TextUnitType.Sp)
    )
}

@Preview
@Composable
private fun PrimaryTextPrev() {
  TravelBudgetManagerTheme {
    Column {
      PrimaryText(text = "Primary")
      PrimaryText(modifier = Modifier.fillMaxWidth(), text = "Primary")
    }
  }
}