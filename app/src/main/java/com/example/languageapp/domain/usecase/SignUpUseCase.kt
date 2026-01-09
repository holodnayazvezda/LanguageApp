package com.example.languageapp.domain.usecase

import com.example.languageapp.domain.models.SignUpModel

class SignUpUseCase {
    fun checkDataForSignUpScreen(signUpModel: SignUpModel): String? {
        if (signUpModel.firstName.isEmpty()) {
            return "First name is empty"
        } else if (signUpModel.lastName.isEmpty()) {
            return "Last name is empty"
        } else if (signUpModel.email.isEmpty()) {
            return "Email is empty"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(signUpModel.email).matches()) {
            return "Invalid email address"
        }
        return null
    }

    fun checkDataForCreatePasswordScreen(signUpModel: SignUpModel): String? {
        val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{8,}$".toRegex()
        if (!signUpModel.password.matches(passwordRegex)) {
            return "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one digit, one special character"
        } else if (signUpModel.password != signUpModel.confirmPassword) {
            return "Passwords do not match"
        } else if (!signUpModel.confirmUserAgreement) {
            return "You must accept the user agreement"
        }
        return null
    }
}