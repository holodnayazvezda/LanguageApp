package com.example.languageapp.domain.di

import com.example.languageapp.domain.usecase.OpenRawPdfUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        OpenRawPdfUseCase(
            context = get()
        )
    }
}