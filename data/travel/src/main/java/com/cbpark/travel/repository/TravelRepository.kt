package com.cbpark.travel.repository

import com.cbpark.travel.entities.Travel

interface TravelRepository {
  suspend fun travels(): List<Travel>
  suspend fun find(name: String): List<Travel>
  suspend fun delete(travel: Travel)
  suspend fun update(travel: Travel)
  suspend fun insert(travel: Travel)
}