package com.example.languageapp.data.storage

import android.content.Context

private const val SharedPreferenceName = "app_preferences"
private const val OnboardingScreenNumber = "onboarding_screen_number"
private const val FirstName = "first_name"
private const val LastName = "last_name"
private const val Email = "email"
private const val Password = "password"
private const val ConfirmPassword = "confirm_password"
private const val ConfirmUserAgreement = "confirm_user_agreement"


class AppStorage(
    context: Context
) : Storage(context, SharedPreferenceName) {
    var onboardingScreenNumber: Int
        get() = getInteger(OnboardingScreenNumber)
        set(value) = putInteger(OnboardingScreenNumber, value)

    var firstName: String?
        get() = getString(FirstName)
        set(value) = putString(FirstName, value)

    var secondName: String?
        get() = getString(LastName)
        set(value) = putString(LastName, value)

    var email: String?
        get() = getString(Email)
        set(value) = putString(Email, value)

    var password: String?
        get() = getString(Password)
        set(value) = putString(Password, value)

    var confirmPassword: String?
        get() = getString(ConfirmPassword)
        set(value) = putString(ConfirmPassword, value)

    var confirmUserAgreement: Boolean
        get() = getInteger(ConfirmUserAgreement) == 0
        set(value) = putInteger(ConfirmUserAgreement, if (value) 1 else 0)

}