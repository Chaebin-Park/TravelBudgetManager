package com.cbpark.traveller_expense.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.cbpark.expense.entity.Expense
import com.cbpark.traveller.entity.Traveller

@Entity(
  primaryKeys = ["traveller_id", "expense_id"],
  foreignKeys = [
    ForeignKey(entity = Traveller::class, parentColumns = ["traveller_id"], childColumns = ["traveller_id"]),
    ForeignKey(entity = Expense::class, parentColumns = ["expense_id"], childColumns = ["expense_id"])
  ]
)
data class TravellerExpenseCrossRef(
  @ColumnInfo(name = "traveller_id") val travellerId: Int,
  @ColumnInfo(name = "expense_id") val expenseId: Int
)