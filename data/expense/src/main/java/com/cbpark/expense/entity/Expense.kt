package com.cbpark.expense.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity(tableName = "expense")
data class Expense(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo("expense_id")
  @SerialName("expense_id")
  val id: Int = 0,
  val name: String,
  val amount: Double
)