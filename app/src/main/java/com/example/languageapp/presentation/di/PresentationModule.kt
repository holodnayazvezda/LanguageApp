package com.example.languageapp.presentation.di

import com.example.languageapp.presentation.components.screen_main_top_app_bar.ScreenMainTopAppBarViewModel
import com.example.languageapp.presentation.screens.exercises.guess_animal_exercise.GuessAnimalExerciseViewModel
import com.example.languageapp.presentation.screens.language_select.LanguageSelectViewModel
import com.example.languageapp.presentation.screens.login.LogInViewModel
import com.example.languageapp.presentation.screens.onboarding.OnboardingScreenViewModel
import com.example.languageapp.presentation.screens.profile.ProfileScreenViewModel
import com.example.languageapp.presentation.screens.signup.SignUpScreenViewModel
import org.koin.dsl.module
import kotlin.math.sin

val presentationModule = module {
    single {
        OnboardingScreenViewModel(
            appStorage = get()
        )
    }

    single {
        LanguageSelectViewModel(
            context = get()
        )
    }

    single {
        SignUpScreenViewModel(
            appStorage = get(),
            openRawPdfUseCase = get()
        )
    }

    single {
        LogInViewModel()
    }

    single {
        ScreenMainTopAppBarViewModel(
            appStorage = get()
        )
    }

    single {
        ProfileScreenViewModel(
            imageUseCase = get(),
            appStorage = get(),
            context = get()
        )
    }

    single {
        GuessAnimalExerciseViewModel()
    }
}