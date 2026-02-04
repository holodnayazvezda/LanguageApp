package com.example.languageapp

import android.app.Application
import com.example.languageapp.data.di.dataModule
import com.example.languageapp.data.di.networkModule
import com.example.languageapp.domain.di.domainModule
import com.example.languageapp.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LanguageApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LanguageApplication)
            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}