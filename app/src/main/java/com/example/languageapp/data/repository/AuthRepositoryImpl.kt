package com.example.languageapp.data.repository

import com.example.languageapp.data.network.LanguageAppApi
import com.example.languageapp.data.network.model.SignUpDto
import com.example.languageapp.domain.models.SignUpModel
import com.example.languageapp.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: LanguageAppApi
) : AuthRepository {
    override suspend fun signUp(signUpModel: SignUpModel): Result<Unit> {
        return try {
            val response = api.signUp(
                SignUpDto(
                    firstName = signUpModel.firstName,
                    lastName = signUpModel.lastName,
                    email = signUpModel.email,
                    password = signUpModel.password
                )
            )
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Registration failed: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}