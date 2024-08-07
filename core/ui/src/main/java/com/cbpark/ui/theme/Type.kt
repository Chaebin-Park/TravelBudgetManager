package com.cbpark.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.cbpark.ui.R

private val pretendardBold = FontFamily(
  Font(R.font.pretendard_bold, FontWeight.Bold)
)
private val pretendardNormal = FontFamily(
  Font(R.font.pretendard_medium, FontWeight.Normal)
)
private val pretendardThin = FontFamily(
  Font(R.font.pretendard_thin, FontWeight.Thin)
)

// Set of Material typography styles to start with
val MyTypography = Typography(
  headlineLarge = TextStyle(
    fontFamily = pretendardBold,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
  ),
  headlineMedium = TextStyle(
    fontFamily = pretendardNormal,
    fontSize = 24.sp
  ),
  headlineSmall = TextStyle(
    fontFamily = pretendardNormal,
    fontSize = 18.sp
  ),

  labelLarge = TextStyle(
    fontFamily = pretendardBold,
    fontSize = 18.sp,
  ),
  labelMedium = TextStyle(
    fontFamily = pretendardNormal,
    fontSize = 18.sp,
  ),
  labelSmall = TextStyle(
    fontFamily = pretendardThin,
    fontSize = 18.sp,
  ),

  bodyLarge = TextStyle(
    fontFamily = pretendardBold,
    fontSize = 15.sp
  ),
  bodyMedium = TextStyle(
    fontFamily = pretendardNormal,
    fontSize = 15.sp,
  ),
  bodySmall = TextStyle(
    fontFamily = pretendardThin,
    fontSize = 15.sp,
  ),
)

val Typography.underlinedButton: TextStyle
  @Composable get() = labelSmall.copy(
    textDecoration = TextDecoration.Underline
  )

