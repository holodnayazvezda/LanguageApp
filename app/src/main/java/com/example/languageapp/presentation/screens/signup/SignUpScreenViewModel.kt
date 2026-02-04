package com.example.languageapp.presentation.screens.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languageapp.R
import com.example.languageapp.data.storage.AppStorage
import com.example.languageapp.domain.models.SignUpModel
import com.example.languageapp.domain.usecase.OpenRawPdfUseCase
import com.example.languageapp.domain.usecase.SignUpUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpScreenViewModel(
    val appStorage: AppStorage,
    val openRawPdfUseCase: OpenRawPdfUseCase,
    val signUpUseCase: SignUpUseCase
): ViewModel() {
    private var _signUpModel = MutableStateFlow(SignUpModel(
        firstName = appStorage.firstName ?: "",
        lastName = appStorage.secondName ?: "",
        email = appStorage.email ?: "",
        password = appStorage.password ?: "",
        confirmPassword = appStorage.confirmPassword ?: "",
        confirmUserAgreement = appStorage.confirmUserAgreement
    ))
    val signUpModel = _signUpModel.asStateFlow();

    fun updateData(
        firstName: String = _signUpModel.value.firstName,
        lastName: String = _signUpModel.value.lastName,
        email: String = _signUpModel.value.email,
        password: String = _signUpModel.value.password,
        confirmPassword: String = _signUpModel.value.confirmPassword,
        confirmUserAgreement: Boolean = _signUpModel.value.confirmUserAgreement
    ) {
        _signUpModel.value = _signUpModel.value.copy(
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            confirmUserAgreement = confirmUserAgreement
        )
        appStorage.firstName = firstName
        appStorage.secondName = lastName
        appStorage.email = email
        appStorage.password = password
        appStorage.confirmPassword = confirmPassword
        appStorage.confirmUserAgreement = confirmUserAgreement
    }

    fun checkOnErrors(checkPassword: Boolean = false): Boolean {
        val errorResId = if (!checkPassword) {
            signUpUseCase.checkDataForSignUpScreen(_signUpModel.value)
        } else {
            signUpUseCase.checkDataForCreatePasswordScreen(_signUpModel.value)
        }
        val isError = errorResId != null
        _signUpModel.value = _signUpModel.value.copy(
            isError = isError,
            errorResId = errorResId
        )
        return isError
    }

    fun register(onSuccess: () -> Unit) {
        if (!checkOnErrors(true)) {
            viewModelScope.launch {
                val result = signUpUseCase(_signUpModel.value)
                if (result.isSuccess) {
                    onSuccess()
                } else {
                    _signUpModel.value = _signUpModel.value.copy(
                        isError = true,
                        errorResId = R.string.error 
                    )
                }
            }
        }
    }

    fun readError() {
        _signUpModel.value = _signUpModel.value.copy(
            isError = false,
            errorResId = null
        )
    }

    fun openPdf(rawResId: Int, fileName: String) {
        openRawPdfUseCase(rawResId, fileName)
    }
}