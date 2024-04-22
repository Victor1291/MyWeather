package com.shu.weather_main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.shu.datastore.DataStoreDataSource
import com.shu.domain.usecase.GetAllCityUseCase
import com.shu.domain.usecase.GetAllWeatherUseCase
import com.shu.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import io.mockk.junit4.MockKRule
import org.junit.Before
import org.junit.Rule
import ua.cn.stu.espresso.apps.testutils.rules.FakeImageLoaderRule

open class BaseTest {

    @get:Rule
    val testViewModelScopeRule = TestViewModelScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mockkRule = MockKRule(this)

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val fakeImageLoaderRule = FakeImageLoaderRule()


    lateinit var getAllWeatherUseCase: GetAllWeatherUseCase
    lateinit var getAllCityUseCase: GetAllCityUseCase
    lateinit var getWeatherUseCase: GetWeatherUseCase
    lateinit var dataStoreDataSource: DataStoreDataSource


    @Before
    open fun setUp() {
        hiltRule.inject()
    }
}