package com.example.languageapp.data.di

import com.example.languageapp.data.repository.AuthRepositoryImpl
import com.example.languageapp.data.storage.AppStorage
import com.example.languageapp.domain.repository.AuthRepository
import org.koin.dsl.module

val dataModule = module {
    single {
        AppStorage(get())
    }
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }
}