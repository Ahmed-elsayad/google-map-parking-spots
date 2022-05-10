package com.example.parkingspots.data

import com.example.parkingspots.domain.model.ParkingSpot

fun ParkingSpotEntity.toParkingSpot(): ParkingSpot{

    return ParkingSpot(
        lat = lat,
        lng = lng,
        id = id
    )
}

fun ParkingSpot.toParkingSpotEntity(): ParkingSpotEntity{

    return ParkingSpotEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}