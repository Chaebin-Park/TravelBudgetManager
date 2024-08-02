package com.cbpark.travel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cbpark.travel.entity.Travel
import com.cbpark.travel.repository.TravelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchTravelViewModel @Inject constructor(
  private val repository: TravelRepository
) : ViewModel() {

  private val _travel = MutableStateFlow<Travel?>(null)
  val travel: StateFlow<Travel?> = _travel.asStateFlow()

  fun findTravelById(id: Int) {
    viewModelScope.launch {
      _travel.value = repository.findById(id)
    }
  }
}