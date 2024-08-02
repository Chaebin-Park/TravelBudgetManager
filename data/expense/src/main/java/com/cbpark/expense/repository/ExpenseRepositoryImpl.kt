package com.cbpark.expense.repository

import com.cbpark.expense.dao.ExpenseDao
import com.cbpark.expense.entity.Expense
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(private val dao: ExpenseDao) : ExpenseRepository {
  override suspend fun insert(expense: Expense) = dao.insert(expense)

  override suspend fun update(expense: Expense) = dao.update(expense)

  override suspend fun delete(expense: Expense) = dao.delete(expense)

}