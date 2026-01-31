package com.example.languageapp.domain.models

data class LogInModel(
    val email: String = "",
    val password: String = "",
    val isError: Boolean = false,
    val errorResId: Int? = null
)
