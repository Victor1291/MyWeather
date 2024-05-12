package com.shu.data.di

import android.content.Context
import androidx.room.Room
import com.shu.data.db.WeatherDatabase
import com.shu.data.db.dao.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): WeatherDatabase =
        Room.databaseBuilder(
            checkNotNull(context.applicationContext),
            WeatherDatabase::class.java,
            "weather"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideWeatherDao(appDatabase: WeatherDatabase): WeatherDao {
        return appDatabase.weatherDao()
    }


}
