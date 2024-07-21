package com.cbpark.travelbudgetmanager.ui.component.button

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.cbpark.travelbudgetmanager.ui.theme.Paddings
import com.cbpark.travelbudgetmanager.ui.theme.Shapes
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme

@Composable
fun SecondaryButton(
  modifier: Modifier = Modifier,
  @StringRes id: Int? = null,
  text: String = "",
  onClick: () -> Unit
) {
  Button(
    border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
    onClick = onClick,
    modifier = modifier.fillMaxWidth(),
    shape = Shapes.medium,
    colors = ButtonDefaults.buttonColors(
      containerColor = MaterialTheme.colorScheme.secondary,
      contentColor = MaterialTheme.colorScheme.onSecondary,
      disabledContainerColor = MaterialTheme.colorScheme.background,
      disabledContentColor = MaterialTheme.colorScheme.onBackground,
    )
  ) {
    Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = id?.let { stringResource(id = id) } ?: text,
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier.padding(Paddings.small)
      )
    }
  }
}

@Preview
@Composable
fun SecondaryButtonPreview() {
  TravelBudgetManagerTheme {
    SecondaryButton(text = "SUBMIT") {

    }
  }
}