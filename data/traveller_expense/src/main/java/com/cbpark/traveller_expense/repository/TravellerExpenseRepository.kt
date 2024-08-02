package com.cbpark.traveller_expense.repository

import com.cbpark.traveller_expense.dao.TravellerExpenseDao
import com.cbpark.traveller_expense.entity.TravellerExpenseCrossRef
import com.cbpark.traveller_expense.relation.ExpenseWithTravellers
import com.cbpark.traveller_expense.relation.TravellerWithExpenses
import javax.inject.Inject

class TravellerExpenseRepository @Inject constructor(private val dao: TravellerExpenseDao) {
  suspend fun insert(travellerExpenseCrossRef: TravellerExpenseCrossRef) =
    dao.insert(travellerExpenseCrossRef)

  suspend fun travellerWithExpenses(travellerId: Int) = dao.travellerWithExpenses(travellerId)

  suspend fun expenseWithTravellers(expenseId: Int) = dao.expenseWithTravellers(expenseId)
}