package com.example.languageapp.data.di

import com.example.languageapp.data.storage.AppStorage
import org.koin.dsl.module

val dataModule = module {
    single {
        AppStorage(get())
    }
}