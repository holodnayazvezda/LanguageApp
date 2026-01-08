package com.example.languageapp.presentation.di

import com.example.languageapp.presentation.screens.language_select.LanguageSelectViewModel
import com.example.languageapp.presentation.screens.onboarding.OnboardingScreenViewModel
import com.example.languageapp.presentation.screens.splash.SplashScreenViewModel
import org.koin.dsl.module

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
}