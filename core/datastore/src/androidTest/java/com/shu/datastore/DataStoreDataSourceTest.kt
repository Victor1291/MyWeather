package com.shu.datastore

import android.content.Context
import android.content.res.Configuration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


private const val TEST_CITY = "Vladivostok"
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class DataStoreRepositoryTest {
    private val testContext: Context =
        InstrumentationRegistry.getInstrumentation().targetContext

    private val testCoroutineDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope =
        TestScope(testCoroutineDispatcher + Job())

    private val dataStore = PreferenceDataStoreFactory.create(scope = testCoroutineScope) {
        testContext.preferencesDataStoreFile(
            "test-preferences-file"
        )
    }

    private val repository = DataStoreDataSourceImpl(dataStore, testContext)

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        testCoroutineDispatcher.cancelChildren()
        testCoroutineScope.launch {
            dataStore.edit {
                it.clear()
            }
        }
        testCoroutineScope.cancel()
    }

    @Test
    fun city_write_test() {
        testCoroutineScope.launch {
            repository.saveCity(TEST_CITY)

            repository.city.first().let {
                assertEquals(TEST_CITY, it)
            }
        }
    }

    //
    @Test
    fun writeTheme() {
        testCoroutineScope.launch {
            repository.saveDarkMode(false)

            repository.isDarkThemeEnabled.first().let {
                assertEquals(false, it)
            }
        }
    }

    @Test
    fun writeThemeDark() {
        testCoroutineScope.launch {
            repository.saveDarkMode(true)

            repository.isDarkThemeEnabled.first().let {
                assertEquals(true, it)
            }
        }
    }

    @Test
    fun testDefaultTheme() {
        testCoroutineScope.launch {
            repository.isDarkThemeEnabled.first().let {
                val exp =
                    (testContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES)
                assertEquals(exp, it)
            }
        }
    }
}