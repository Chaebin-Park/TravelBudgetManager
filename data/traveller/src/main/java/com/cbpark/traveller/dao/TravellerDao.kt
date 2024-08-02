package com.cbpark.traveller.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cbpark.traveller.entity.Traveller

@Dao
interface TravellerDao {
  @Insert
  suspend fun insert(traveller: Traveller)

  @Update
  suspend fun update(traveller: Traveller)

  @Delete
  suspend fun delete(traveller: Traveller)

  @Query("SELECT * FROM traveller WHERE travel_id = :travelId")
  suspend fun travellers(travelId: Int): List<Traveller>
}