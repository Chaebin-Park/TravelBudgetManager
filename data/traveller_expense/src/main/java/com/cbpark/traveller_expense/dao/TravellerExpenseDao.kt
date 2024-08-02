package com.cbpark.traveller_expense.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.cbpark.traveller_expense.entity.TravellerExpenseCrossRef
import com.cbpark.traveller_expense.relation.ExpenseWithTravellers
import com.cbpark.traveller_expense.relation.TravellerWithExpenses

@Dao
interface TravellerExpenseDao {
  @Insert
  suspend fun insert(travellerExpenseCrossRef: TravellerExpenseCrossRef)

  @Transaction
  @Query("SELECT * FROM traveller WHERE traveller_id = :travellerId")
  suspend fun travellerWithExpenses(travellerId: Int): List<TravellerWithExpenses>

  @Transaction
  @Query("SELECT * FROM expense WHERE expense_id = :expenseId")
  suspend fun expenseWithTravellers(expenseId: Int): List<ExpenseWithTravellers>
}