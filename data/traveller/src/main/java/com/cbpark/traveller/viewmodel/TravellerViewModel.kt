package com.cbpark.traveller.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.cbpark.traveller.entity.Traveller
import com.cbpark.traveller.repository.TravellerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TravellerViewModel @Inject constructor(
  private val

  repository: TravellerRepository
) : ViewModel() {

  fun insertTraveller(traveller: Traveller) {
    viewModelScope.launch {
      repository.insert(traveller)
    }
  }

  fun updateTraveller(traveller: Traveller) {
    viewModelScope.launch {
      repository.update(traveller)
    }
  }

  fun deleteTraveller(traveller: Traveller) {
    viewModelScope.launch {
      repository.delete(traveller)
    }
  }

  fun getTravellersForTravel(travelId: Int): LiveData<List<Traveller>> = liveData {
    emit(repository.travellers(travelId))
  }
}