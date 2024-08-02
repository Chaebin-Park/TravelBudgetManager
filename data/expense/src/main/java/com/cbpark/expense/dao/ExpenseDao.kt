package com.cbpark.expense.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.cbpark.expense.entity.Expense

@Dao
interface ExpenseDao {
  @Insert
  suspend fun insert(expense: Expense)

  @Update
  suspend fun update(expense: Expense)

  @Delete
  suspend fun delete(expense: Expense)
}