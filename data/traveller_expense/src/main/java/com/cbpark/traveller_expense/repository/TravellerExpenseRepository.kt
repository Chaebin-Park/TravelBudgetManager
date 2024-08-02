package com.cbpark.traveller_expense.repository

import com.cbpark.traveller_expense.entity.TravellerExpenseCrossRef
import com.cbpark.traveller_expense.relation.ExpenseWithTravellers
import com.cbpark.traveller_expense.relation.TravellerWithExpenses

interface TravellerExpenseRepository {
  suspend fun insert(travellerExpenseCrossRef: TravellerExpenseCrossRef)
  suspend fun travellerWithExpenses(travellerId: Int) : List<TravellerWithExpenses>
  suspend fun expenseWithTravellers(expenseId: Int) : List<ExpenseWithTravellers>
}