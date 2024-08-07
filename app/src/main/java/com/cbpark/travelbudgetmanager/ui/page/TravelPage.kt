package com.cbpark.travelbudgetmanager.ui.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.cbpark.travel.entity.Travel
import com.cbpark.ui.button.TestButton
import com.cbpark.ui.text.TitleText
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TravelPage(travel: Travel) {
  val pagerState = rememberPagerState { 3 }
  Column {
    NavigationBar(pagerState = pagerState, travel = travel)
    CustomViewPager(pagerState = pagerState, travel = travel)
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomViewPager(pagerState: PagerState, travel: Travel) {
  HorizontalPager(
    modifier = Modifier.fillMaxSize(),
    verticalAlignment = Alignment.CenterVertically,
    state = pagerState
  ) {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center, // 세로 방향으로 가운데 정렬
      horizontalAlignment = Alignment.CenterHorizontally // 가로 방향으로 가운데 정렬
    ) {
      when (it) {
        0 -> TravellerPage(travel = travel)
        1 -> ExpensePage()
        2 -> TotalPage()
      }
    }
  }
}

@Composable
fun TravellerPage(
  modifier: Modifier = Modifier,
  travel: Travel
) {
  Column {
    TitleText(text = "Traveller Page")
    TestButton(modifier)
  }
}

@Composable
fun ExpensePage(modifier: Modifier = Modifier) {
  Column {
    TitleText(text = "Expense Page")
  }
}

@Composable
fun TotalPage(modifier: Modifier = Modifier) {
  Column {
    TitleText(text = "Total Page")
  }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun NavigationBar(pagerState: PagerState, travel: Travel) {
  val coroutineScope = rememberCoroutineScope()

  Row(
    modifier = Modifier
      .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly
  ) {
    repeat(pagerState.pageCount) { page ->
      Button(
        onClick = {
          coroutineScope.launch {
            pagerState.animateScrollToPage(page)
          }
        },
        colors = ButtonDefaults.buttonColors(
          containerColor = if (pagerState.currentPage == page) Color.Gray else Color.LightGray
        ),
        modifier = Modifier.weight(1f)
      ) {
        when (page) {
          0 -> {
            Text(text = "Traveller")
          }

          1 -> {
            Text(text = "Expense")
          }

          2 -> {
            Text(text = "Total")
          }
        }
      }
    }
  }
}