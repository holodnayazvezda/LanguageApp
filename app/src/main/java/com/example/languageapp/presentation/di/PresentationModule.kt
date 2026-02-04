package com.example.languageapp.presentation.di

import com.example.languageapp.presentation.components.profile_screen_top_app_bar.ProfileScreenTopAppBarViewModel
import com.example.languageapp.presentation.components.screen_main_top_app_bar.ScreenMainTopAppBarViewModel
import com.example.languageapp.presentation.screens.exercises.audition_exercise.AuditionExerciseViewModel
import com.example.languageapp.presentation.screens.exercises.game_exercise.GameExerciseViewModel
import com.example.languageapp.presentation.screens.exercises.guess_animal_exercise.GuessAnimalExerciseViewModel
import com.example.languageapp.presentation.screens.exercises.word_practice_exercise.WordPracticeExerciseViewModel
import com.example.languageapp.presentation.screens.language_select.LanguageSelectViewModel
import com.example.languageapp.presentation.screens.login.LogInViewModel
import com.example.languageapp.presentation.screens.main.MainScreenViewModel
import com.example.languageapp.presentation.screens.onboarding.OnboardingScreenViewModel
import com.example.languageapp.presentation.screens.profile.ProfileScreenViewModel
import com.example.languageapp.presentation.screens.signup.SignUpScreenViewModel
import com.example.languageapp.presentation.screens.splash.SplashScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        OnboardingScreenViewModel(
            appStorage = get()
        )
    }

    viewModel {
        SplashScreenViewModel(
            appStorage = get()
        )
    }

    viewModel {
        LanguageSelectViewModel(
            appStorage = get()
        )
    }

    viewModel {
        SignUpScreenViewModel(
            appStorage = get(),
            openRawPdfUseCase = get(),
            signUpUseCase = get()
        )
    }

    viewModel {
        LogInViewModel(
            appStorage = get()
        )
    }

    viewModel {
        MainScreenViewModel(
            getUserUseCase = get(),
            getLeaderboardUseCase = get(),
            getExercisesUseCase = get()
        )
    }

    viewModel {
        ProfileScreenViewModel(
            imageUseCase = get(),
            appStorage = get(),
            context = androidContext(),
            getUserUseCase = get(),
            uploadAvatarUseCase = get()
        )
    }

    viewModel { ScreenMainTopAppBarViewModel(appStorage = get(), getUserUseCase = get()) }

    viewModel { ProfileScreenTopAppBarViewModel(appStorage = get(), getUserUseCase = get()) }

    viewModel { GuessAnimalExerciseViewModel() }
    viewModel { WordPracticeExerciseViewModel() }
    viewModel { AuditionExerciseViewModel() }
    viewModel { GameExerciseViewModel() }
}