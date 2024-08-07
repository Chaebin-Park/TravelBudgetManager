package com.cbpark.ui.button

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cbpark.ui.theme.Shapes

@Composable
fun PagerButton(
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  buttonColors: ButtonColors,
  onClick: () -> Unit,
  content: @Composable RowScope.() -> Unit
) {
  Button(
    modifier = modifier,
    onClick = onClick,
    shape = Shapes.extraSmall,
    colors = buttonColors,
    enabled = enabled
  )
  { content() }
}