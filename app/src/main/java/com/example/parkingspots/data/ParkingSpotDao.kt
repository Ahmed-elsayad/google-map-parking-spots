package com.example.parkingspots.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ParkingSpotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParkingSpot(spot: ParkingSpotEntity)

    @Delete
    suspend fun deleteParkingSopt(spot: ParkingSpotEntity)
    @Query("select * from ParkingSpotEntity ")
     fun getParkingSpots(): Flow<List<ParkingSpotEntity>>


}