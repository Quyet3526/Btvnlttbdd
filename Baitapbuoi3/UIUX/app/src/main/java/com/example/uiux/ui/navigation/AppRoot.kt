package com.example.uiux.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uiux.ui.image.ImageScreen
import com.example.uiux.ui.input.InputScreen
import com.example.uiux.ui.layout.LayoutScreen
import com.example.uiux.ui.list.ListScreen
import com.example.uiux.ui.mainPage.MainScreen
import com.example.uiux.ui.text.TextScreen

@Composable
fun AppRoot(){
    val nav = rememberNavController()

    Scaffold { inner ->
        NavHost(
            navController = nav,
            startDestination = Routes.Home,
            modifier = Modifier.padding(inner)
        ){
            composable(Routes.Home) {
                MainScreen(
                    onGoList = {nav.navigateSingleTop(Routes.List)}
                )
            }

            composable(Routes.List) {
                ListScreen(
                    onGoImage = {nav.navigateSingleTop(Routes.Image)},
                    onGoText = {nav.navigateSingleTop(Routes.Text)},
                    onGoLayout = {nav.navigateSingleTop(Routes.Layout)},
                    onGoInput = {nav.navigateSingleTop(Routes.Input)}
                )
            }

            composable(Routes.Image) {
                ImageScreen(
                    onGoBack = {nav.navigateSingleTop(Routes.List)},
                )
            }

            composable(Routes.Input) {
                InputScreen(
                    onGoBack = {nav.navigateSingleTop(Routes.List)}
                )
            }

            composable(Routes.Layout){
                LayoutScreen(
                    onGoBack = {nav.navigateSingleTop(Routes.List)}
                )
            }

            composable(Routes.Text){
                TextScreen(
                    onGoBack = {nav.navigateSingleTop(Routes.List)}
                )
            }

        }
    }
}

private fun androidx.navigation.NavHostController.navigateSingleTop(route: String) {
    navigate(route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(graph.startDestinationId) { saveState = true }
    }
}

