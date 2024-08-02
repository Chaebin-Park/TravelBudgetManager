package com.cbpark.module

import android.content.Context
import androidx.room.Room
import com.cbpark.expense.dao.ExpenseDao
import com.cbpark.travel.dao.TravelDao
import com.cbpark.traveller.dao.TravellerDao
import com.cbpark.traveller_expense.dao.TravellerExpenseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase
  = Room.databaseBuilder(
      appContext,
      AppDatabase::class.java,
      "app_database"
    ).build()

  @Provides
  fun provideTravelDao(db: AppDatabase): TravelDao {
    return db.travelDao()
  }

  @Provides
  fun provideTravellerDao(db:AppDatabase): TravellerDao {
    return db.travellerDao()
  }

  @Provides
  fun provideExpenseDao(db: AppDatabase): ExpenseDao {
    return db.expenseDao()
  }

  @Provides
  fun provideTravellerExpenseDao(db: AppDatabase): TravellerExpenseDao {
    return db.travellerExpenseDao()
  }
}