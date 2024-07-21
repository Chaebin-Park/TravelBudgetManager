package com.cbpark.travel.module

import android.app.Application
import androidx.room.Room
import com.cbpark.travel.db.TravelDatabase
import com.cbpark.travel.repository.TravelRepository
import com.cbpark.travel.repository.TravelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object TravelModule {
  @Provides
  @Singleton
  fun provideTravelDatabase(app: Application): TravelDatabase {
    return Room.databaseBuilder(
      app,
      TravelDatabase::class.java,
      "travel.db"
    ).fallbackToDestructiveMigration().build()
  }

  @Provides
  @Singleton
  fun provideTravelRepository(db: TravelDatabase): TravelRepository =
    TravelRepositoryImpl(db.travelDao)
}