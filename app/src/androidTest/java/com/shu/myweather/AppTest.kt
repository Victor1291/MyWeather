package com.shu.myweather

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AppTest {


    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun app_launches() {
        // Check app launches at the correct destination
        composeTestRule.onNodeWithText("Search").assertIsDisplayed()
    }

    @Test
    fun app_canNavigateToAllScreens() {
        // Check app launches at HOME
        composeTestRule.onNodeWithText("Search").assertIsDisplayed()

        // Navigate to Search
        composeTestRule.onNodeWithText("City").performClick().assertIsDisplayed()
    }

   /* @Test
    fun app_canNavigateToDetailPage() {
        composeTestRule.onNodeWithText("City").performClick().assertIsDisplayed()
        composeTestRule.onNodeWithText("Moscow").performClick()
        composeTestRule.onNodeWithText("Weather").assertIsDisplayed()
    }*/
}
