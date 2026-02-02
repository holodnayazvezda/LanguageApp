package com.example.languageapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.languageapp.presentation.screens.exercises.audition_exercise.AuditionExercise
import com.example.languageapp.presentation.screens.exercises.game_exercise.GameExercise
import com.example.languageapp.presentation.screens.exercises.guess_animal_exercise.CorrectAnswerScreen
import com.example.languageapp.presentation.screens.exercises.guess_animal_exercise.GuessAnimalExercise
import com.example.languageapp.presentation.screens.exercises.guess_animal_exercise.GuessAnimalExerciseViewModel
import com.example.languageapp.presentation.screens.exercises.guess_animal_exercise.WrongAnswerScreen
import com.example.languageapp.presentation.screens.exercises.word_practice_exercise.WordPracticeExercise
import com.example.languageapp.presentation.screens.exercises.word_practice_exercise.WordPracticeExerciseViewModel
import com.example.languageapp.presentation.screens.language_select.LanguageSelectScreen
import com.example.languageapp.presentation.screens.login.LogInScreen
import com.example.languageapp.presentation.screens.login.LogInViewModel
import com.example.languageapp.presentation.screens.main.MainScreen
import com.example.languageapp.presentation.screens.onboarding.OnboardingScreen
import com.example.languageapp.presentation.screens.profile.ProfileScreen
import com.example.languageapp.presentation.screens.profile.ProfileScreenViewModel
import com.example.languageapp.presentation.screens.profile.ChooseImageScreen
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
    val profileScreenViewModel = koinViewModel<ProfileScreenViewModel>()
    val guessAnimalExerciseViewModel = koinViewModel<GuessAnimalExerciseViewModel>()
    val wordPracticeExerciseViewModel = koinViewModel<WordPracticeExerciseViewModel>()
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
            MainScreen(
                navigateToProfile = { navController.navigate(NavigationRoutes.PROFILE.route) },
                navigateToGuessAnimalExercise = { navController.navigate(NavigationRoutes.GUESS_ANIMAL_EXERCISE.route) },
                navigateToWordPracticeExercise = { navController.navigate(NavigationRoutes.WORD_PRACTICE_EXERCISE.route) },
                navigateToAuditionExercise = { navController.navigate(NavigationRoutes.AUDITION_EXERCISE.route) },
                navigateToGameExercise = { navController.navigate(NavigationRoutes.GAME_EXERCISE.route) }
            )
        }
        composable(NavigationRoutes.GAME_EXERCISE.route) {
            GameExercise()
        }
        composable(NavigationRoutes.AUDITION_EXERCISE.route) {
            AuditionExercise()
        }
        composable(NavigationRoutes.GUESS_ANIMAL_EXERCISE.route) {
            GuessAnimalExercise(
                navigateToMainScreen = {
                    navController.navigate(NavigationRoutes.MAIN_SCREEN.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                navigateToCorrectAnswerScreen = { navController.navigate(NavigationRoutes.CORRECT_ANSWER_SCREEN.route) },
                navigateToWrongAnswerScreen = { navController.navigate(NavigationRoutes.WRONG_ANSWER_SCREEN.route) },
                viewModel = guessAnimalExerciseViewModel
            )
        }
        composable(NavigationRoutes.CORRECT_ANSWER_SCREEN.route) {
            CorrectAnswerScreen(
                navigateToMainScreen = {
                    navController.navigate(NavigationRoutes.MAIN_SCREEN.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                navigateToGuessAnimal = { navController.popBackStack() },
                viewModel = guessAnimalExerciseViewModel
            )
        }
        composable(NavigationRoutes.WRONG_ANSWER_SCREEN .route) {
            WrongAnswerScreen(
                navigateToMainScreen = {
                    navController.navigate(NavigationRoutes.MAIN_SCREEN.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                navigateToGuessAnimal = { navController.popBackStack() },
                viewModel = guessAnimalExerciseViewModel
            )
        }
        composable(NavigationRoutes.WORD_PRACTICE_EXERCISE.route) {
            WordPracticeExercise(
                navigateToMainScreen = {
                    navController.navigate(NavigationRoutes.MAIN_SCREEN.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                viewModel = wordPracticeExerciseViewModel
            )
        }
        composable(NavigationRoutes.PROFILE.route) {
            ProfileScreen(
                navigateToChangeLanguage = { navController.navigate(NavigationRoutes.LANGUAGE_SELECT_SCREEN.route) },
                navigateToChooseImage = { navController.navigate(NavigationRoutes.CHOOSE_IMAGE.route) },
                viewModel = profileScreenViewModel
            )
        }
        composable(NavigationRoutes.CHOOSE_IMAGE.route) {
            ChooseImageScreen(
                profileScreenViewModel = profileScreenViewModel,
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}