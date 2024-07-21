package com.cbpark.travel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cbpark.travel.entities.Travel
import com.cbpark.travel.repository.TravelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TravelViewModel @Inject constructor(
  private val repository: TravelRepository
): ViewModel() {
  private val _travels = MutableStateFlow<List<Travel>>(emptyList())
  val travels: StateFlow<List<Travel>> get() = _travels

  init {
    loadTravels()
  }

  fun insert(travel: Travel) {
    viewModelScope.launch {
      repository.insert(travel)
      loadTravels()
    }
  }

  fun update(travel: Travel) {
    viewModelScope.launch {
      repository.update(travel)
      loadTravels()
    }
  }

  fun delete(travel: Travel) {
    viewModelScope.launch {
      repository.delete(travel)
      loadTravels()
    }
  }

  private fun loadTravels() {
    viewModelScope.launch {
      val travels = repository.travels()
      _travels.value = travels
    }
  }
}