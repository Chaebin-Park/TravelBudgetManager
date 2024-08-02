package com.cbpark.expense.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cbpark.expense.entity.Expense
import com.cbpark.expense.repository.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
  private val repository: ExpenseRepository
) : ViewModel() {

  fun insertExpense(expense: Expense) {
    viewModelScope.launch {
      repository.insert(expense)
    }
  }

  fun updateExpense(expense: Expense) {
    viewModelScope.launch {
      repository.update(expense)
    }
  }

  fun deleteExpense(expense: Expense) {
    viewModelScope.launch {
      repository.delete(expense)
    }
  }
}