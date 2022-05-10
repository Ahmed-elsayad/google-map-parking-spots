package com.example.parkingspots.presentation

import com.example.parkingspots.domain.model.ParkingSpot
import com.google.android.gms.maps.model.LatLng

sealed class MapEvent{
    object  ToggleFalloutMap: MapEvent()
    data class OnMapLongClick(val latlng: LatLng): MapEvent()
    data class OnInfoWindowlongClick(val spot: ParkingSpot): MapEvent()

}