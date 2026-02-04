package com.example.languageapp.domain.di

import com.example.languageapp.domain.usecase.GetExercisesUseCase
import com.example.languageapp.domain.usecase.GetLeaderboardUseCase
import com.example.languageapp.domain.usecase.GetUserUseCase
import com.example.languageapp.domain.usecase.ImageUseCase
import com.example.languageapp.domain.usecase.OpenRawPdfUseCase
import com.example.languageapp.domain.usecase.SignUpUseCase
import com.example.languageapp.domain.usecase.UploadAvatarUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        OpenRawPdfUseCase(
            context = get()
        )
    }

    single {
        ImageUseCase(
            context = get()
        )
    }

    factory {
        SignUpUseCase(get())
    }

    factory { GetUserUseCase(get()) }
    factory { GetLeaderboardUseCase(get()) }
    factory { GetExercisesUseCase(get()) }
    factory { UploadAvatarUseCase(get()) }
}