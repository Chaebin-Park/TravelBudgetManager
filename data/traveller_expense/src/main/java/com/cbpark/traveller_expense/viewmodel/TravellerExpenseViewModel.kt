package com.cbpark.traveller_expense.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.cbpark.traveller_expense.entity.TravellerExpenseCrossRef
import com.cbpark.traveller_expense.relation.ExpenseWithTravellers
import com.cbpark.traveller_expense.relation.TravellerWithExpenses
import com.cbpark.traveller_expense.repository.TravellerExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TravellerExpenseViewModel @Inject constructor(
  private val repository: TravellerExpenseRepository
) : ViewModel() {

  fun insertTravellerExpense(travellerExpenseCrossRef: TravellerExpenseCrossRef) {
    viewModelScope.launch {
      repository.insert(travellerExpenseCrossRef)
    }
  }

  fun getTravellerWithExpenses(travellerId: Int): LiveData<List<TravellerWithExpenses>> = liveData {
    emit(repository.travellerWithExpenses(travellerId))
  }

  fun getExpenseWithTravellers(expenseId: Int): LiveData<List<ExpenseWithTravellers>> = liveData {
    emit(repository.expenseWithTravellers(expenseId))
  }
}