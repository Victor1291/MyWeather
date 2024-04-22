package com.shu.weather_main

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shu.weather_main.cityscreen.CityScreen
import com.shu.weather_main.cityscreen.DetailScreen

sealed class BottomNavigationScreens(val route: String, @StringRes val label: Int, val icon: ImageVector) {
    data object MainScreen : BottomNavigationScreens(
        route = "main_screen",
        label = R.string.search,
        icon = Icons.Default.Person
    )

    data object LocationScreen : BottomNavigationScreens(
        route = "location_screen",
        label = R.string.city,
        icon = Icons.Default.Home
    )

    data object DetailScreen : BottomNavigationScreens(
        route = "detail_screen",
        label = R.string.weather,
        icon = Icons.Default.Menu
    )
}

val bottomNavigationItems = listOf(
    BottomNavigationScreens.MainScreen,
    BottomNavigationScreens.LocationScreen,
)

@Composable
fun MainNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: WeatherMainViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreens.MainScreen.route
    ) {
        composable(BottomNavigationScreens.MainScreen.route) {
            viewModel.changeStateTOpBar(true)
            WeatherApp(viewModel)
        }
        composable(BottomNavigationScreens.LocationScreen.route) {
            viewModel.changeStateTOpBar(false)
            viewModel.getAllCity()
            CityScreen(viewModel, onCityClicked = {
                viewModel.choiceCity = it ?: "Vladivostok"
                navController.navigate(
                    BottomNavigationScreens.DetailScreen.route
                )
            })
        }
        composable(BottomNavigationScreens.DetailScreen.route) {
            viewModel.getWeather()
            DetailScreen(viewModel)
          /*  BackHandler {
                navController.navigateUp()
            }*/
        }
    }
}
