package com.example.languageapp.domain.usecase

import com.example.languageapp.R
import com.example.languageapp.domain.models.LogInModel

class LogInUseCase {
    operator fun invoke(logInModel: LogInModel): Int? {
        if (logInModel.email.isEmpty()) {
            return R.string.error_email_empty
        }
        if (logInModel.password.isEmpty()) {
            return R.string.error_password_empty
        }
        return null
    }
}