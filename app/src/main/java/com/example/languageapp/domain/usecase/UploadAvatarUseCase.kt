package com.example.languageapp.domain.usecase

import com.example.languageapp.domain.repository.MainRepository
import java.io.File

class UploadAvatarUseCase(private val repository: MainRepository) {
    suspend operator fun invoke(file: File): Result<Unit> {
        return repository.uploadAvatar(file)
    }
}