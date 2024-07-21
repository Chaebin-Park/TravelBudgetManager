package com.cbpark.travel.repository

import com.cbpark.travel.dao.TravelDao
import com.cbpark.travel.entities.Travel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TravelRepositoryImpl @Inject constructor(
  private val dao: TravelDao
) : TravelRepository {
  override suspend fun travels(): List<Travel> {
    return withContext(Dispatchers.IO) {
      dao.travels()
    }
  }

  override suspend fun find(name: String): List<Travel> {
    return withContext(Dispatchers.IO) {
      dao.find(name)
    }
  }

  override suspend fun delete(travel: Travel) {
    withContext(Dispatchers.IO) {
      dao.delete(travel)
    }
  }

  override suspend fun update(travel: Travel) {
    withContext(Dispatchers.IO) {
      dao.update(travel)
    }
  }

  override suspend fun insert(travel: Travel) {
    withContext(Dispatchers.IO) {
      dao.insert(travel)
    }
  }
}