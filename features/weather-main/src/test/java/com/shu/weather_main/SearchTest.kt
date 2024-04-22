package com.shu.weather_main

import com.shu.entity.models.Location
import org.junit.Assert
import org.junit.Test

class SearchTest {


    @Test
    fun checkSearch() {
        val listCity = listOf<Location>(
            Location(
                name = "Moscow",null,null,null,null,null,null,null
            ),
            Location(
                name = "London",null,null,null,null,null,null,null
            ),
            Location(
                name = "Paris",null,null,null,null,null,null,null
            ),
            Location(
                name = "Vladivostok",null,null,null,null,null,null,null
            ),
            Location(
                name = "Sydney",null,null,null,null,null,null,null
            )
        )

        val testWord1 = "lon"
        val expectedWord = "London"

        val actualList = Utils.search(testWord1,listCity)
        Assert.assertEquals(expectedWord, actualList.first().name)

    }

}