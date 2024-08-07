package com.cbpark.ui.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cbpark.ui.text.PrimaryText
import com.cbpark.ui.theme.CustomTheme
import com.cbpark.ui.theme.Primary
import com.cbpark.ui.theme.Shapes

@Composable
fun PrimaryButton(
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  onClick: () -> Unit,
  content: @Composable RowScope.() -> Unit
) {
  val buttonColors = ButtonColors(
    containerColor = Primary,
    contentColor = Color.LightGray,
    disabledContainerColor = Color.DarkGray,
    disabledContentColor = Color.White
  )

  Button(
    modifier = modifier,
    onClick = onClick,
    shape = Shapes.medium,
    colors = buttonColors,
    enabled = enabled
  )
  { content() }
}

@Preview
@Composable
private fun PrimaryButtonPrev() {
  CustomTheme {
    Column {
      PrimaryButton(
        onClick = {},
        content = {
          PrimaryText(text = "Enable")
        }
      )

      PrimaryButton(
        onClick = {},
        enabled = false,
        content = {
          PrimaryText(text = "Disable")
        }
      )
    }
  }
}