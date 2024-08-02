package com.cbpark.traveller_expense.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.cbpark.expense.entity.Expense
import com.cbpark.traveller.entity.Traveller
import com.cbpark.traveller_expense.entity.TravellerExpenseCrossRef

data class TravellerWithExpenses(
  @Embedded val traveller: Traveller,
  @Relation(
    parentColumn = "traveller_id",
    entityColumn = "expense_id",
    associateBy = Junction(TravellerExpenseCrossRef::class)
  )
  val expenses: List<Expense>
)