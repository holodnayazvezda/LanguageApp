package com.example.languageapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.languageapp.presentation.screens.language_select.LanguageSelectScreen
import com.example.languageapp.presentation.screens.login.LogInScreen
import com.example.languageapp.presentation.screens.login.LogInViewModel
import com.example.languageapp.presentation.screens.main.MainScreen
import com.example.languageapp.presentation.screens.onboarding.OnboardingScreen
import com.example.languageapp.presentation.screens.signup.CreatePasswordScreen
import com.example.languageapp.presentation.screens.signup.SignUpScreen
import com.example.languageapp.presentation.screens.signup.SignUpScreenViewModel
import com.example.languageapp.presentation.screens.splash.SplashScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationHost(
    navController: NavHostController = rememberNavController()
) {
    val signUpViewModel = koinViewModel<SignUpScreenViewModel>()
    val logInViewModel = koinViewModel<LogInViewModel>()
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
            LanguageSelectScreen(
                navigateToNextScreen = {
                    navController.navigate(NavigationRoutes.SIGN_UP_SCREEN.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(NavigationRoutes.SIGN_UP_SCREEN.route) {
            SignUpScreen(
                navigateBack = { navController.navigate(NavigationRoutes.LOG_IN_SCREEN.route) },
                navigateToCreatePasswordScreen = { navController.navigate(NavigationRoutes.CREATE_PASSWORD_SCREEN.route) },
                viewModel = signUpViewModel
            )
        }
        composable(NavigationRoutes.CREATE_PASSWORD_SCREEN.route) {
            CreatePasswordScreen(
                navigateBack = { navController.popBackStack() },
                navigateToLogin = { navController.navigate(NavigationRoutes.LOG_IN_SCREEN.route) },
                viewModel = signUpViewModel
            )
        }
        composable(NavigationRoutes.LOG_IN_SCREEN.route) {
            LogInScreen(
                navigateBack = {
                    navController.navigate(NavigationRoutes.LANGUAGE_SELECT_SCREEN.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                navigateToMainScreen = {
                    navController.navigate(NavigationRoutes.MAIN_SCREEN.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                navigateToSignUp = {navController.navigate(NavigationRoutes.SIGN_UP_SCREEN.route)},
                viewModel = logInViewModel
            )
        }
        composable(NavigationRoutes.MAIN_SCREEN.route) {
            MainScreen()
        }
    }
}