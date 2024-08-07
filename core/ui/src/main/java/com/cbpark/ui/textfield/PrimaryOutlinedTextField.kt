package com.cbpark.ui.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cbpark.ui.text.PrimaryText
import com.cbpark.ui.theme.Shapes
import com.cbpark.ui.theme.CustomTheme

@Composable
fun PrimaryOutlinedTextField(
  modifier: Modifier = Modifier,
  text: String = "",
  hint: String = "",
  onTextChanged: (String) -> Unit
) {
  Column {
    OutlinedTextField(
      value = text,
      onValueChange = {
        onTextChanged(it)
      },
      modifier = modifier.fillMaxWidth(),
      shape = Shapes.large,
      label = { PrimaryText(text = hint) },
      singleLine = true,
    )
  }
}

@Preview
@Composable
private fun PrimaryTextFieldPrev() {
  CustomTheme {
    PrimaryOutlinedTextField(
      modifier = Modifier.background(color = Color.White),
      text = "",
      hint = "Hint",
      onTextChanged = {}
    )
  }
}