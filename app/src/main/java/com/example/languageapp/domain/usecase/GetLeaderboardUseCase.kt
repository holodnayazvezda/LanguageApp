package com.example.languageapp.domain.usecase

import com.example.languageapp.domain.models.TopUsersModel
import com.example.languageapp.domain.repository.MainRepository

class GetLeaderboardUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Result<List<TopUsersModel>> {
        return repository.getLeaderboard()
    }
}