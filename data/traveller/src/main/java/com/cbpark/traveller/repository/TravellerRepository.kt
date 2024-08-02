package com.cbpark.traveller.repository

import com.cbpark.traveller.entity.Traveller

interface TravellerRepository {
  suspend fun insert(traveller: Traveller)
  suspend fun update(traveller: Traveller)
  suspend fun delete(traveller: Traveller)
  suspend fun travellers(travelId: Int): List<Traveller>
}