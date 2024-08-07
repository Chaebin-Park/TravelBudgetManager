package com.cbpark.travelbudgetmanager.ui.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cbpark.travel.entity.CountryCode
import com.cbpark.travel.entity.Travel
import com.cbpark.ui.button.PrimaryButton
import com.cbpark.ui.datepicker.CustomDatePicker
import com.cbpark.ui.text.BoldText
import com.cbpark.ui.text.PrimaryText
import com.cbpark.ui.textfield.PrimaryOutlinedTextField
import com.cbpark.ui.theme.Paddings
import com.cbpark.ui.theme.CustomTheme
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTravelBottomSheetDialog(
  originTravel: Travel,
  onConfirm: (Travel) -> Unit,
  onCancel: () -> Unit
) {
  val modalBottomSheetState = rememberModalBottomSheetState()
  val scope = rememberCoroutineScope()
  val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
  var travelTitle by remember { mutableStateOf(originTravel.name) }
  var countryCode by remember { mutableStateOf(CountryCode.find(originTravel.countryCode)) }
  var startDate by remember { mutableStateOf<LocalDate>(LocalDate.now()) }
  var endDate by remember { mutableStateOf<LocalDate>(LocalDate.now()) }

  ModalBottomSheet(
    onDismissRequest = { onCancel() },
    sheetState = modalBottomSheetState,
    dragHandle = { BottomSheetDefaults.DragHandle() }
  ) {
    Column(
      modifier = Modifier.padding(
        horizontal = Paddings.medium,
        vertical = bottomPadding + Paddings.medium
      )
    ) {
      BoldText(
        modifier = Modifier
          .padding(bottom = Paddings.large)
          .fillMaxWidth(),
        text = "여행 정보를 입력 하세요"
      )

      PrimaryOutlinedTextField(
        modifier = Modifier.padding(bottom = Paddings.large),
        text = travelTitle,
        hint = "여행 제목",
        onTextChanged = { newTitle -> travelTitle = newTitle }
      )

      BoldText(
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = Paddings.large),
        text = "여행 국가"
      )
      Column(
        modifier = Modifier
          .height(100.dp)
          .verticalScroll(rememberScrollState())
      ) {
        CountryList { newCountryCode ->
          countryCode = newCountryCode
        }
      }

      BoldText(
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = Paddings.medium),
        text = "여행 날짜"
      )

      Row (
        modifier = Modifier
          .padding(bottom = Paddings.medium)
          .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
      ) {
        CustomDatePicker(onDateSelected = { date ->
          startDate = date
        })
        PrimaryText(text = "~")
        CustomDatePicker(onDateSelected = { date ->
          endDate = date
        })
      }

      Spacer(modifier = Modifier.height(Paddings.medium))
      PrimaryButton(
        onClick = {
          scope.launch {
            modalBottomSheetState.hide()
          }.invokeOnCompletion {
            val travel = originTravel.copy(
              countryCode = countryCode.code,
              name = travelTitle.trim(),
              currency = countryCode.currency,
              startDate = startDate,
              endDate = endDate
            )
            onConfirm(travel)
            onCancel()
          }
        },
        content = { PrimaryText(text = "여행 수정")},
      )
    }
  }
}

@Preview
@Composable
private fun EditTravelBottomSheetDialogPrev() {
  CustomTheme {
    EditTravelBottomSheetDialog(
      originTravel = Travel(),
      onConfirm = {},
      onCancel = {}
    )
  }
}