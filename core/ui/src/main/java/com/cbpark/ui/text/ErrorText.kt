package com.cbpark.ui.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cbpark.ui.theme.CustomTheme

@Composable
fun ErrorText(
  modifier: Modifier = Modifier,
  @StringRes id: Int? = null,
  text: String = ""
) {

  Row (
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(
      imageVector = Icons.Default.Info,
      contentDescription = "Error Icon",
      tint = Color.Red // 원하는 색상으로 변경 가능
    )
    Spacer(modifier = Modifier.width(4.dp))
    Text(
      modifier = modifier,
      text = id?.let { stringResource(id = id) } ?: text,
      color = Color.Red,
      style = MaterialTheme.typography.labelSmall,
    )
  }
}

@Preview
@Composable
private fun ErrorTextPrev() {
  CustomTheme {
    ErrorText(text = "Error")
  }
}