package com.cbpark.travelbudgetmanager.ui.component.button

import androidx.annotation.StringRes
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
import com.cbpark.travelbudgetmanager.ui.theme.Paddings
import com.cbpark.travelbudgetmanager.ui.theme.Primary
import com.cbpark.travelbudgetmanager.ui.theme.Shapes
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme

@Composable
fun PrimaryButton(
  modifier: Modifier = Modifier,
  @StringRes id: Int? = null,
  text: String = "",
  onClick: () -> Unit
) {
  Button(
    onClick = onClick,
    modifier = modifier.fillMaxWidth(),
    shape = Shapes.large,
    colors = ButtonDefaults.buttonColors(
      containerColor = Primary,
      contentColor = MaterialTheme.colorScheme.onPrimary,
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
        modifier = Modifier.padding(Paddings.large)
      )
    }
  }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
  TravelBudgetManagerTheme {
    PrimaryButton (text = "Primary") {

    }
  }
}