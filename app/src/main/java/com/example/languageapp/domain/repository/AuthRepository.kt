package com.example.languageapp.domain.repository

import com.example.languageapp.domain.models.SignUpModel

interface AuthRepository {
    suspend fun signUp(signUpModel: SignUpModel): Result<Unit>
}