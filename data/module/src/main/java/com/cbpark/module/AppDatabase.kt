package com.cbpark.module

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.cbpark.expense.dao.ExpenseDao
import com.cbpark.expense.entity.Expense
import com.cbpark.travel.dao.TravelDao
import com.cbpark.travel.entity.Travel
import com.cbpark.traveller.dao.TravellerDao
import com.cbpark.traveller.entity.Traveller
import com.cbpark.traveller_expense.dao.TravellerExpenseDao
import com.cbpark.traveller_expense.entity.TravellerExpenseCrossRef

@Database(
  entities = [Travel::class, Traveller::class, Expense::class, TravellerExpenseCrossRef::class],
  version = 1
)
abstract class AppDatabase: RoomDatabase() {
  abstract fun travelDao(): TravelDao
  abstract fun travellerDao(): TravellerDao
  abstract fun expenseDao(): ExpenseDao
  abstract fun travellerExpenseDao(): TravellerExpenseDao

  companion object {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          AppDatabase::class.java,
          "app_database"
        )
//          .addMigrations(MIGRATION_1_2)
          .build()
        INSTANCE = instance
        instance
      }
    }

//    val MIGRATION_1_2 = object : Migration(1, 2) {
//      override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE traveller ADD COLUMN budget REAL NOT NULL DEFAULT 0.0")
//      }
//    }
  }
}