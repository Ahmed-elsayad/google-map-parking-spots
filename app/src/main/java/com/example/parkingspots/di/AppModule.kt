package com.example.parkingspots.di

import android.app.Application
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.room.Room
import com.example.parkingspots.data.ParkingSpotDatabase
import com.example.parkingspots.data.ParkingSpotRepositoryImpl
import com.example.parkingspots.domain.repository.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application): ParkingSpotDatabase{
        return Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "parking_spots.db"
        ).build()
    }
    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSpotDatabase): ParkingSpotRepository{

        return ParkingSpotRepositoryImpl(db.dao)
    }
}