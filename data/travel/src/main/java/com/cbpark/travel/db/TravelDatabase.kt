package com.cbpark.travel.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cbpark.travel.converter.LocalDateConverter
import com.cbpark.travel.dao.TravelDao
import com.cbpark.travel.entity.Travel

@Database(entities = [Travel::class], version = 2, exportSchema = false)
@TypeConverters(LocalDateConverter::class)
abstract class TravelDatabase: RoomDatabase() {
  abstract val travelDao: TravelDao
}