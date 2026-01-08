package com.example.languageapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.languageapp.presentation.screens.language_select.LanguageSelectScreen
import com.example.languageapp.presentation.screens.onboarding.OnboardingScreen
import com.example.languageapp.presentation.screens.splash.SplashScreen

@Composable
fun NavigationHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.SPLASH_SCREEN.route,
    ) {
        composable(NavigationRoutes.SPLASH_SCREEN.route) {
            SplashScreen(
                navigateToNextScreen = { route ->
                    navController.navigate(route) {
                        popUpTo(NavigationRoutes.ONBOARDING_SCREEN.route) { inclusive = true }
                    }
                }
            )
        }
        composable(NavigationRoutes.ONBOARDING_SCREEN.route) {
            OnboardingScreen(
                navigateToNextScreen = {
                    navController.navigate(NavigationRoutes.LANGUAGE_SELECT_SCREEN.route)
                }
            )
        }
        composable(NavigationRoutes.LANGUAGE_SELECT_SCREEN.route) {
            LanguageSelectScreen()
        }
    }
}