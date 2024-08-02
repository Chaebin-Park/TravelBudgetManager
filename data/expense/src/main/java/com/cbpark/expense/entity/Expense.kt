package com.cbpark.expense.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class Expense(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  val name: String,
  val amount: Double
)