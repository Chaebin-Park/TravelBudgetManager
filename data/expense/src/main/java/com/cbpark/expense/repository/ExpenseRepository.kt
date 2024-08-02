package com.cbpark.expense.repository

import com.cbpark.expense.entity.Expense

interface ExpenseRepository {
  suspend fun insert(expense: Expense)
  suspend fun update(expense: Expense)
  suspend fun delete(expense: Expense)
}