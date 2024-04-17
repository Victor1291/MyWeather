package com.shu.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreDataSource {

    val isDarkThemeEnabled: Flow<Boolean>

    val city: Flow<String>


    suspend fun saveCity(city: String)

    suspend fun saveDarkMode(isDark: Boolean)
}