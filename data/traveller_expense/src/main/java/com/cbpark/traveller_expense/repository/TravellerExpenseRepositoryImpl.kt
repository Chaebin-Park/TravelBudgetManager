package com.cbpark.traveller_expense.repository

import com.cbpark.traveller_expense.dao.TravellerExpenseDao
import com.cbpark.traveller_expense.entity.TravellerExpenseCrossRef
import javax.inject.Inject

class TravellerExpenseRepositoryImpl @Inject constructor(private val dao: TravellerExpenseDao) : TravellerExpenseRepository {
  override suspend fun insert(travellerExpenseCrossRef: TravellerExpenseCrossRef) = dao.insert(travellerExpenseCrossRef)

  override suspend fun travellerWithExpenses(travellerId: Int) = dao.travellerWithExpenses(travellerId)

  override suspend fun expenseWithTravellers(expenseId: Int) = dao.expenseWithTravellers(expenseId)
}