package com.cbpark.traveller_expense.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.cbpark.expense.entity.Expense
import com.cbpark.traveller.entity.Traveller
import com.cbpark.traveller_expense.entity.TravellerExpenseCrossRef

data class ExpenseWithTravellers(
  @Embedded val expense: Expense,
  @Relation(
    parentColumn = "expense_id",
    entityColumn = "traveller_id",
    associateBy = Junction(TravellerExpenseCrossRef::class)
  )
  val travellers: List<Traveller>
)