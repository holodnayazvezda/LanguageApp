package com.example.languageapp.data.storage

import android.content.Context

private const val SharedPreferenceName = "app_preferences"
private const val OnboardingScreenNumber = "onboarding_screen_number"

class AppStorage(
    context: Context
) : Storage(context, SharedPreferenceName) {
    var onboardingScreenNumber: Int
        get() = getInteger(OnboardingScreenNumber)
        set(value) = putInteger(OnboardingScreenNumber, value)
}