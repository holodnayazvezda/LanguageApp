package com.example.languageapp.domain.models

data class SignUpModel(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val confirmUserAgreement: Boolean = false,
    val isError: Boolean = false,
    val errorText: String = ""
)
