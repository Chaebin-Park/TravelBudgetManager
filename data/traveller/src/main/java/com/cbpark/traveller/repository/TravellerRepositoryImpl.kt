package com.cbpark.traveller.repository

import com.cbpark.traveller.dao.TravellerDao
import com.cbpark.traveller.entity.Traveller
import javax.inject.Inject

class TravellerRepositoryImpl @Inject constructor(private val dao: TravellerDao) : TravellerRepository {
  override suspend fun insert(traveller: Traveller) = dao.insert(traveller)

  override suspend fun update(traveller: Traveller) = dao.update(traveller)

  override suspend fun delete(traveller: Traveller) = dao.delete(traveller)

  override suspend fun travellers(travelId: Int): List<Traveller> = dao.travellers(travelId)
}