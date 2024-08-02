package com.cbpark.travel.repository

import com.cbpark.travel.dao.TravelDao
import com.cbpark.travel.entity.Travel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TravelRepositoryImpl @Inject constructor(
  private val dao: TravelDao
) : TravelRepository {
  override suspend fun travels(): List<Travel> = dao.travels()

  override suspend fun find(name: String): List<Travel> = dao.find(name)

  override suspend fun delete(travel: Travel) = dao.delete(travel)

  override suspend fun update(travel: Travel) = dao.update(travel)

  override suspend fun insert(travel: Travel) = dao.insert(travel)
}