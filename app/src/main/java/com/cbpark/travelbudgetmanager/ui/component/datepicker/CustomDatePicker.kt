package com.cbpark.travelbudgetmanager.ui.component.datepicker

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.cbpark.travelbudgetmanager.ui.component.text.PrimaryText
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme
import java.time.LocalDate
import java.util.Calendar

@Composable
fun CustomDatePicker(
  modifier: Modifier = Modifier,
  onDateSelected: (LocalDate) -> Unit
) {
  var selectedDate by remember { mutableStateOf(LocalDate.now()) }
  val context = LocalContext.current
  val calendar = Calendar.getInstance()

  val year = calendar.get(Calendar.YEAR)
  val month = calendar.get(Calendar.MONTH)
  val day = calendar.get(Calendar.DAY_OF_MONTH)

  val datePickerDialog = DatePickerDialog(
    context,
    { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
      selectedDate = LocalDate.of(selectedYear, selectedMonth + 1, selectedDay)
      onDateSelected(selectedDate)
    }, year, month, day
  )

  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    PrimaryText(
      text = selectedDate?.toString() ?: "No date selected",
      modifier = Modifier
        .clickable {
          datePickerDialog.show()
        }
    )
  }
}

@Preview
@Composable
private fun PrevDatePicker() {
  TravelBudgetManagerTheme {
    CustomDatePicker() {}
  }
}