package com.shu.myweather.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.shu.data.api.ServiceWeatherApi
import com.shu.data.db.dao.WeatherDao
import com.shu.data.repository.WeatherRepositoryImpl
import com.shu.datastore.DataStoreDataSource
import com.shu.datastore.DataStoreDataSourceImpl
import com.shu.datastore.dataStore
import com.shu.domain.repository.WeatherRepository
import com.shu.domain.usecase.GetAllCityUseCase
import com.shu.domain.usecase.GetAllWeatherUseCase
import com.shu.domain.usecase.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WeatherModule {
    @Provides
    fun providesRepository(
        weatherDao: WeatherDao,
        api: ServiceWeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherDao, api)
    }

    @Singleton
    @Provides
    fun provideDataSource(
        @ApplicationContext context: Context
    ): DataStore<androidx.datastore.preferences.core.Preferences> = context.dataStore

    @Singleton
    @Provides
    fun provideDataStore(
        dataStore: DataStore<androidx.datastore.preferences.core.Preferences>,
        @ApplicationContext context: Context
    ): DataStoreDataSource {
       return DataStoreDataSourceImpl(dataStore,context)
    }

    @Provides
    fun provideGetAllWeatherUseCase(repository: WeatherRepository): GetAllWeatherUseCase {
        return GetAllWeatherUseCase(repository)
    }

    @Provides
    fun provideGetAllCityUseCase(repository: WeatherRepository): GetAllCityUseCase {
        return GetAllCityUseCase(repository)
    }

    @Provides
    fun provideGetWeatherUseCase(repository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(repository)
    }
}