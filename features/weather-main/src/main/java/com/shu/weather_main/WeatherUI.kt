@file:OptIn(ExperimentalMaterial3Api::class)

package com.shu.weather_main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun WeatherMain(viewModel: WeatherMainViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val stateTOpBar by viewModel.stateTOpBar.collectAsState()


    Scaffold(
        topBar = {
            if (stateTOpBar) {
                MaterialSearch(viewModel)
            } else {
                TopItem(
                    header = "Cities ",
                    leftIconImageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    onLeftIconClick = { navController.navigateUp() },
                )
            }
        },
        content = { MainNavHost(navController, it, viewModel) },
        bottomBar = {
            BottomNav(navController, bottomNavigationItems)
        }
    )
}

@Composable
fun BottomNav(navController: NavHostController, items: List<BottomNavigationScreens>) {
    BottomAppBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = "icon for navigation item"
                    )
                },
                label = { Text(text = stringResource(screen.label)) },
                onClick = {
                    when (currentRoute) {
                        "main_screen" -> {
                            when (screen.route) {
                                "location_screen" -> {
                                    navController.navigate(screen.route) {

                                    }
                                }
                                "allCity_screen" -> {
                                    navController.navigate(screen.route) {

                                    }
                                }
                                else -> {}
                            }
                        }

                        "location_screen" -> {
                            when (screen.route) {
                                "detail_screen" -> {
                                    navController.navigate(screen.route) {
                                    }
                                }

                                "main_screen" -> {
                                    navController.navigate(screen.route) {
                                        popUpTo(screen.route) { inclusive = true }
                                    }
                                }
                                "allCity_screen" -> {
                                    navController.navigate(screen.route) {
                                        popUpTo(screen.route) { inclusive = true }
                                    }
                                }

                                else -> {}
                            }
                        }

                        "allCity_screen" -> {
                            when (screen.route) {
                                "main_screen" -> {
                                    navController.navigate(screen.route) {
                                        popUpTo(screen.route) { inclusive = true }
                                    }
                                }
                                "location_screen" -> {
                                    navController.navigate(screen.route) {
                                        popUpTo(screen.route) { inclusive = true }
                                    }
                                }
                                else -> {}
                            }
                        }

                        "detail_screen" -> {
                            navController.navigate(screen.route) {
                                popUpTo(screen.route) { inclusive = false }
                            }
                        }

                        else -> {}
                    }
                    /* if (currentRoute != screen.route) {

                     }*/
                }
            )
        }
    }
}
