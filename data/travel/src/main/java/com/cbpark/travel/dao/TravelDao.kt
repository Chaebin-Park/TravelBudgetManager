package com.cbpark.travel.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cbpark.travel.entity.Travel

@Dao
interface TravelDao {
  @Query("""
    SELECT * FROM travel
  """)
  suspend fun travels(): List<Travel>

  @Query("SELECT * FROM travel WHERE name LIKE :name")
  suspend fun find(name: String): List<Travel>

  @Delete
  suspend fun delete(travel: Travel)

  @Update
  suspend fun update(travel: Travel)

  @Insert
  suspend fun insert(travel: Travel)
}