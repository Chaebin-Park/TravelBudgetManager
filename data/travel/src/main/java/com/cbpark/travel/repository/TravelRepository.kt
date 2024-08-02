package com.cbpark.travel.repository

import com.cbpark.travel.dao.TravelDao
import com.cbpark.travel.entity.Travel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TravelRepository @Inject constructor(private val dao: TravelDao) {
  fun travels(): Flow<List<Travel>> = dao.travels()

  suspend fun find(name: String): List<Travel> = dao.find(name)

  suspend fun delete(travel: Travel) = dao.delete(travel)

  suspend fun update(travel: Travel) = dao.update(travel)

  suspend fun insert(travel: Travel) = dao.insert(travel)
}