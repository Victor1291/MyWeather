package com.shu.datastore

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    context: Context
) : DataStoreDataSource {
    companion object {
        //App settings
        val IS_DARK_THEME = booleanPreferencesKey(Constants.AppSettings.IS_DARK_THEME)

        val CITY = stringPreferencesKey(Constants.AppSettings.CITY)
    }


    //DarkMode flag
    override val isDarkThemeEnabled: Flow<Boolean> = dataStore.data.map {
        it[IS_DARK_THEME]
            ?: (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES)
    }.distinctUntilChanged()

    override val city: Flow<String> =
        dataStore.data.map {
            it[CITY] ?: "Moscow"
        }.distinctUntilChanged()

    override suspend fun saveCity(city: String) {
        dataStore.edit {
            it[CITY] = city
        }
    }

    override suspend fun saveDarkMode(isDark: Boolean) {
        dataStore.edit {
            it[IS_DARK_THEME] = isDark
        }
    }
}