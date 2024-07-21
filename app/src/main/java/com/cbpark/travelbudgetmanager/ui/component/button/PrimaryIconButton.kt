package com.cbpark.travelbudgetmanager.ui.component.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cbpark.travelbudgetmanager.ui.theme.Paddings
import com.cbpark.travelbudgetmanager.ui.theme.Primary
import com.cbpark.travelbudgetmanager.ui.theme.Shapes
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme

@Composable
fun PrimaryIconButton(
  modifier: Modifier = Modifier,
  icon: ImageVector = Icons.Default.Add,
  onClick: () -> Unit
) {
  IconButton(
    modifier = modifier.size(60.dp),
    onClick = onClick,
    colors = IconButtonColors(
      containerColor = Primary,
      contentColor = MaterialTheme.colorScheme.onPrimary,
      disabledContainerColor = MaterialTheme.colorScheme.background,
      disabledContentColor = MaterialTheme.colorScheme.onBackground,
    )
  ) {
    Icon(imageVector = icon, contentDescription = "Icon button image vector")
  }
}

@Preview
@Composable
fun PrimaryIconButtonPreview() {
  TravelBudgetManagerTheme {
    PrimaryIconButton (icon = Icons.Default.Add) {

    }
  }
}