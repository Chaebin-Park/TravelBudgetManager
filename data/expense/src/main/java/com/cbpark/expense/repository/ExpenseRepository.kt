package com.cbpark.expense.repository

import com.cbpark.expense.dao.ExpenseDao
import com.cbpark.expense.entity.Expense
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val dao: ExpenseDao) {
  suspend fun insert(expense: Expense) = dao.insert(expense)

  suspend fun update(expense: Expense) = dao.update(expense)

  suspend fun delete(expense: Expense) = dao.delete(expense)

}