package com.example.parkingspots.domain.repository

import com.example.parkingspots.domain.model.ParkingSpot
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepository {
    suspend fun  insertParkingSpot(spot: ParkingSpot)
    suspend fun  deleteParkingSpot(spot: ParkingSpot)
    fun getParkingSpots(): Flow<List<ParkingSpot>>
}