package com.cbpark.travelbudgetmanager.ui.page

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cbpark.travel.entity.CountryCode
import com.cbpark.travel.entity.Travel
import com.cbpark.travel.viewmodel.TravelViewModel
import com.cbpark.travelbudgetmanager.R
import com.cbpark.travelbudgetmanager.TravelActivity
import com.cbpark.travelbudgetmanager.ui.component.TopBar
import com.cbpark.travelbudgetmanager.ui.component.dialog.CustomAlertDialog
import com.cbpark.travelbudgetmanager.ui.component.dialog.EditTravelBottomSheetDialog
import com.cbpark.travelbudgetmanager.ui.component.dialog.TravelBottomSheetDialog
import com.cbpark.travelbudgetmanager.ui.component.text.PrimaryText
import com.cbpark.travelbudgetmanager.ui.component.text.SmallText
import com.cbpark.travelbudgetmanager.ui.component.text.TitleText
import com.cbpark.travelbudgetmanager.ui.theme.Paddings
import com.cbpark.travelbudgetmanager.ui.theme.Tertiary
import com.cbpark.travelbudgetmanager.ui.theme.TravelBudgetManagerTheme
import java.time.format.DateTimeFormatter

data class DeleteTravelState(
  val showDialog: Boolean = false,
  val delete: () -> Unit = {}
)

data class UpdateTravelState(
  val showDialog: Boolean = false,
  val originTravel: Travel = Travel(),
  val update: (Travel) -> Unit = {}
)

@Composable
fun TravelPage(
  modifier: Modifier = Modifier,
  travelViewModel: TravelViewModel = viewModel(),
) {
  val context = LocalContext.current
  var showSheet by remember { mutableStateOf(false) }
  var deleteTravelState by remember { mutableStateOf(DeleteTravelState()) }
  var updateTravelState by remember { mutableStateOf(UpdateTravelState()) }

  val travels by travelViewModel.getAllTravels().observeAsState(initial = emptyList())


  val insertTravel: (Travel) -> Unit = { travel: Travel ->
    if (travel.name.isNotEmpty()) {
      travelViewModel.insertTravel(travel)
    } else {
      Toast.makeText(context, "여행 타이틀을 입력 하세요", Toast.LENGTH_SHORT).show()
    }
  }
  val updateTravel: (Travel) -> Unit = { travel: Travel ->
    updateTravelState = UpdateTravelState(
      showDialog = true,
      originTravel = travel,
      update = { newTravel -> travelViewModel.updateTravel(newTravel) }
    )
  }
  val deleteTravel: (Travel) -> Unit = { travel: Travel ->
    deleteTravelState = DeleteTravelState(
      showDialog = true,
      delete = { travelViewModel.deleteTravel(travel) }
    )
  }

  Scaffold(
    topBar = {
      TopBar(
        optionalIcon = {
          IconButton(onClick = { showSheet = true }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
          }
        }
      )
    },
  ) { paddingValue ->
    TravelPage(
      modifier = modifier.padding(paddingValue),
      travels = travels,
      updateTravel = updateTravel,
      deleteTravel = deleteTravel
    )
    if (showSheet) {
      TravelBottomSheetDialog(
        onConfirm = { travel ->
          insertTravel(travel)
        },
        onCancel = {
          showSheet = false
        }
      )
    }
    if (updateTravelState.showDialog) {
      EditTravelBottomSheetDialog(
        originTravel = updateTravelState.originTravel,
        onConfirm = { travel ->
          updateTravelState.update(travel)
          updateTravelState = UpdateTravelState()
        },
        onCancel = { updateTravelState = UpdateTravelState() }
      )
    }
    if (deleteTravelState.showDialog) {
      CustomAlertDialog(
        title = "정말 삭제 하시겠습니까?",
        description = "삭제된 데이터는 복구할 수 없습니다.",
        onClickCancel = { deleteTravelState = DeleteTravelState() },
        onClickConfirm = {
          deleteTravelState.delete()
          deleteTravelState = DeleteTravelState()
        }
      )
    }
  }
}

@Composable
fun TravelPage(
  modifier: Modifier = Modifier,
  travels: List<Travel>,
  updateTravel: (travel: Travel) -> Unit,
  deleteTravel: (travel: Travel) -> Unit
) {
  LazyVerticalGrid(
    modifier = modifier.fillMaxSize(),
    columns = GridCells.Fixed(2),
    contentPadding = PaddingValues(Paddings.medium),
    verticalArrangement = Arrangement.spacedBy(Paddings.medium),
    horizontalArrangement = Arrangement.spacedBy(Paddings.medium)
  ) {
    items(travels) { travel ->
      TravelItem(
        travel = travel,
        updateTravel = updateTravel,
        deleteTravel = deleteTravel
      )
    }
  }
}

@Composable
fun TravelItem(
  travel: Travel,
  updateTravel: (travel: Travel) -> Unit,
  deleteTravel: (travel: Travel) -> Unit,
) {
  var expanded by remember { mutableStateOf(false) }
  val context = LocalContext.current

  Card(
    elevation = CardDefaults.cardElevation(3.dp),
    onClick = {
      val intent = Intent(context, TravelActivity::class.java)
      context.startActivity(intent)
    }
  ) {
    Box(
      modifier = Modifier
        .background(color = Tertiary)
        .fillMaxWidth()
    ) {
      Column(
        modifier = Modifier.padding(Paddings.large)
      ) {
        Row {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(bottom = Paddings.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
          ) {
            val code = CountryCode.find(code = travel.countryCode)
            SmallText(text = "${code.code} ${code.name}")
            IconButton(
              modifier = Modifier.then(Modifier.size(24.dp)),
              onClick = { expanded = true }
            ) {
              Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More Options")
            }
          }
          DropdownMenu(
            modifier = Modifier.background(color = Color.White),
            expanded = expanded,
            onDismissRequest = { expanded = false }
          ) {
            DropdownMenuItem(
              text = { PrimaryText(text = "편집") },
              onClick = {
                updateTravel(travel)
                expanded = false
              })
            DropdownMenuItem(
              text = { PrimaryText(text = "삭제") },
              onClick = {
                deleteTravel(travel)
                expanded = false
              })
          }
        }

        TitleText(text = travel.name)

        Spacer(modifier = Modifier.height(Paddings.xxLarge))

        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        Row {
          SmallText(
            text = """
            ${travel.startDate.format(formatter)}
            ~ ${travel.endDate.format(formatter)}
            """.trimIndent()
          )
        }
      }
    }
  }
}

private fun flagImage(countryCode: String): Int =
  when (CountryCode.find(code = countryCode)) {
    CountryCode.USA -> R.drawable.usa_flag
    CountryCode.Japan -> R.drawable.japan_flag
    CountryCode.Mongolia -> R.drawable.mongolia_flag
    CountryCode.Vietnam -> R.drawable.vietnam_flag
  }

@Preview
@Composable
private fun TravelPagePrev() {
  val testList = listOf(
    Travel(0, CountryCode.Mongolia.code, "Test1", "USD"),
    Travel(0, CountryCode.USA.code, "Test2", "USD"),
    Travel(0, CountryCode.Vietnam.code, "Test3", "USD"),
    Travel(0, CountryCode.Japan.code, "Test4", "USD"),
    Travel(0, CountryCode.Mongolia.code, "Test5", "USD"),
    Travel(0, CountryCode.Mongolia.code, "Test6", "USD"),
    Travel(0, CountryCode.Mongolia.code, "Test7", "USD"),
  )
  TravelBudgetManagerTheme {
    TravelPage(
      travels = testList,
      updateTravel = {},
      deleteTravel = {}
    )
  }
}