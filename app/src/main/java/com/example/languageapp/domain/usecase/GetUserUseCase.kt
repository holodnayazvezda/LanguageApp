package com.example.languageapp.domain.usecase

import com.example.languageapp.domain.models.UserModel
import com.example.languageapp.domain.repository.MainRepository

class GetUserUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Result<UserModel> {
        return repository.getUser()
    }
}