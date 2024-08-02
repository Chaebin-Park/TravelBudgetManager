package com.cbpark.travel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.cbpark.travel.entity.Travel
import com.cbpark.travel.repository.TravelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TravelViewModel @Inject constructor(
  private val repository: TravelRepository
) : ViewModel() {

  val travels: StateFlow<List<Travel>> = repository.travels()
    .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

  fun insertTravel(travel: Travel) {
    viewModelScope.launch {
      repository.insert(travel)
    }
  }

  fun updateTravel(travel: Travel) {
    viewModelScope.launch {
      repository.update(travel)
    }
  }

  fun deleteTravel(travel: Travel) {
    viewModelScope.launch {
      repository.delete(travel)
    }
  }

  fun findTravelsByName(name: String): LiveData<List<Travel>> = liveData {
    emit(repository.findByName(name))
  }
}