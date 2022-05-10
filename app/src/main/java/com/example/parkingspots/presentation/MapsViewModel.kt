package com.example.parkingspots.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parkingspots.domain.model.ParkingSpot
import com.example.parkingspots.domain.repository.ParkingSpotRepository
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: ParkingSpotRepository
): ViewModel() {
    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            repository.getParkingSpots().collectLatest {spots ->
                state = state.copy(
                    parkingSpots = spots
                )
            }
        }
    }

    fun onEvent(event:MapEvent){
        when(event){
            is MapEvent.ToggleFalloutMap ->  {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions = if(state.isFallOutMap){
                            null
                        }else MapStyleOptions(MapStyle.json),
                    ),
                    isFallOutMap = !state.isFallOutMap
                )
            }

            is MapEvent.OnMapLongClick -> {
                viewModelScope.launch {
                    repository.insertParkingSpot(ParkingSpot(
                        event.latlng.latitude,
                        event.latlng.longitude
                    ))
                }
            }
            is MapEvent.OnInfoWindowlongClick -> {
                viewModelScope.launch {
                    repository.deleteParkingSpot(event.spot)
                }
            }
        }
    }

}