package com.cbpark.ui.textfield

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cbpark.ui.text.PrimaryText
import com.cbpark.ui.theme.Shapes
import com.cbpark.ui.theme.CustomTheme

@Composable
fun PrimaryTextField(
  text: String,
  hint: String,
  onTextChanged: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  Column {
    TextField(
      value = text,
      onValueChange = {
        onTextChanged(it)
      },
      modifier = modifier
        .fillMaxWidth()
        .background(color = Color.Transparent)
        .border(BorderStroke(0.dp, color = Color.Transparent)),
      shape = Shapes.large,
      label = { if (text.isEmpty()) PrimaryText(text = hint) },
      singleLine = true,
      keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
      keyboardActions = KeyboardActions(onDone = { /* Handle action */ })
    )
  }
}

@Preview
@Composable
private fun PrimaryTextFieldPrev() {
  CustomTheme {
    PrimaryTextField(
      text = "",
      hint = "add task",
      onTextChanged = {}
    )
  }
}