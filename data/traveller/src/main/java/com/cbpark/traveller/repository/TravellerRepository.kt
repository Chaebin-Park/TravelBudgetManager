package com.cbpark.traveller.repository

import com.cbpark.traveller.dao.TravellerDao
import com.cbpark.traveller.entity.Traveller
import javax.inject.Inject

class TravellerRepository @Inject constructor(private val dao: TravellerDao) {
  suspend fun insert(traveller: Traveller) = dao.insert(traveller)

  suspend fun update(traveller: Traveller) = dao.update(traveller)

  suspend fun delete(traveller: Traveller) = dao.delete(traveller)

  suspend fun travellers(travelId: Int): List<Traveller> = dao.travellers(travelId)
}