package com.example.languageapp.presentation.screens.login

import androidx.lifecycle.ViewModel
import com.example.languageapp.domain.models.LogInModel
import com.example.languageapp.domain.usecase.LogInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LogInViewModel(
    val logInUseCase: LogInUseCase = LogInUseCase()
): ViewModel() {
    private var _logInModel = MutableStateFlow(LogInModel(
        email = "",
        password = ""
    ))
    val logInModel = _logInModel.asStateFlow()

    fun updateData(
        email: String = logInModel.value.email,
        password: String = logInModel.value.password
    ) {
        _logInModel.value = _logInModel.value.copy(
            email = email,
            password = password
        )
    }

    fun checkOnErrors(): Boolean {
        val errorTextResId = logInUseCase(_logInModel.value)
        val isError = errorTextResId != null
        _logInModel.value = _logInModel.value.copy(
            isError = isError,
            errorResId = errorTextResId
        )
        return isError
    }

    fun readError() {
        _logInModel.value = _logInModel.value.copy(
            isError = false,
            errorResId = null
        )
    }
}