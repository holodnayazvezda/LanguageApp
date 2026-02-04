package com.example.languageapp.domain.di

import com.example.languageapp.domain.usecase.ImageUseCase
import com.example.languageapp.domain.usecase.OpenRawPdfUseCase
import com.example.languageapp.domain.usecase.SignUpUseCase
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
}