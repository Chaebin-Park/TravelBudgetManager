package com.cbpark.travelbudgetmanager.ui.component.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.cbpark.travelbudgetmanager.ui.theme.MyTypography
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme

@Composable
fun TitleText(
  modifier: Modifier = Modifier,
  @StringRes id: Int? = null,
  text: String = ""
) {
  Text(
    modifier = modifier,
    text = id?.let { stringResource(id = id) } ?: text,
    style = MyTypography.headlineLarge,
    textAlign = TextAlign.Center,
    fontSize = TextUnit(20f, TextUnitType.Sp),
  )
}

@Preview
@Composable
private fun TitleTextPrev() {
  TravelBudgetManagerTheme {
    TitleText(text = "Title")
  }
}