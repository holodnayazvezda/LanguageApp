package com.example.languageapp.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import com.example.languageapp.data.storage.AppStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OnboardingScreenViewModel(
    private val appStorage: AppStorage
): ViewModel() {
    private val _screenNumber = MutableStateFlow(appStorage.onboardingScreenNumber)
    val screenNumber = _screenNumber.asStateFlow()

    fun updateScreenNumber(newNumber: Int) {
        appStorage.onboardingScreenNumber = newNumber
        _screenNumber.value = newNumber
    }
}