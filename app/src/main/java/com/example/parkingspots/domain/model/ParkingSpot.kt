package com.example.parkingspots.domain.model

data class ParkingSpot(
    val lat: Double,
    val lng: Double,
    val id: Int?  = null
)
