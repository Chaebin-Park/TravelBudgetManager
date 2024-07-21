package com.cbpark.travelbudgetmanager.ui.component.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme
import com.cbpark.travelbudgetmanager.ui.theme.underlinedButton

@Composable
fun UnderlinedTextButtonWithNoPaddings(
  modifier: Modifier = Modifier,
  @StringRes id: Int? = null,
  text: String = "",
  onClick: () -> Unit
) {
  Button(
    modifier = modifier.defaultMinSize(1.dp, 1.dp),
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
      containerColor = MaterialTheme.colorScheme.background,
      contentColor = MaterialTheme.colorScheme.secondary,
      disabledContentColor = MaterialTheme.colorScheme.background,
      disabledContainerColor = MaterialTheme.colorScheme.onBackground
    ),
    elevation = null
  ) {
    Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = id?.let { stringResource(id = id) } ?: text,
        style = MaterialTheme.typography.underlinedButton,
      )
    }
  }
}

@Preview
@Composable
private fun UnderlinedTextButtonWithNoPaddingsPrev() {
  TravelBudgetManagerTheme {
    UnderlinedTextButtonWithNoPaddings(
      text = "Test"
    ) {}
  }
}