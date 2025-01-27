package com.cbpark.travel.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cbpark.travel.entity.Travel
import kotlinx.coroutines.flow.Flow

@Dao
interface TravelDao {
  @Query("""
    SELECT * FROM travel
  """)
  fun travels(): Flow<List<Travel>>

  @Query("SELECT * FROM travel WHERE name LIKE '%' || :name || '%'")
  suspend fun findByName(name: String): List<Travel>

  @Query("SELECT * FROM travel WHERE id LIKE :id LIMIT 1")
  suspend fun findById(id: Int): Travel

  @Delete
  suspend fun delete(travel: Travel)

  @Update
  suspend fun update(travel: Travel)

  @Insert
  suspend fun insert(travel: Travel)
}