package com.example.languageapp.domain.usecase

import com.example.languageapp.R
import com.example.languageapp.domain.models.SignUpModel
import com.example.languageapp.domain.repository.AuthRepository

class SignUpUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(signUpModel: SignUpModel): Result<Unit> {
        return repository.signUp(signUpModel)
    }

    fun checkDataForSignUpScreen(signUpModel: SignUpModel): Int? {
        if (signUpModel.firstName.isEmpty()) {
            return R.string.error_first_name_empty
        } else if (signUpModel.lastName.isEmpty()) {
            return R.string.error_last_name_empty
        } else if (signUpModel.email.isEmpty()) {
            return R.string.error_email_empty
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(signUpModel.email).matches()) {
            return R.string.error_invalid_email
        }
        return null
    }

    fun checkDataForCreatePasswordScreen(signUpModel: SignUpModel): Int? {
        val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{8,}$".toRegex()
        if (!signUpModel.password.matches(passwordRegex)) {
            return R.string.error_password_requirements
        } else if (signUpModel.password != signUpModel.confirmPassword) {
            return R.string.error_passwords_do_not_match
        } else if (!signUpModel.confirmUserAgreement) {
            return R.string.error_accept_agreement
        }
        return null
    }
}