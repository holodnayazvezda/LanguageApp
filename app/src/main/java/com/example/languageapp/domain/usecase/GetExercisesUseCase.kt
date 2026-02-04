package com.example.languageapp.domain.usecase

import com.example.languageapp.domain.models.ExerciseModel
import com.example.languageapp.domain.repository.MainRepository

class GetExercisesUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(): Result<List<ExerciseModel>> {
        return repository.getExercises()
    }
}