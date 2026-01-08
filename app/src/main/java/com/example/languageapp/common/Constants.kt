package com.example.languageapp.common

import com.example.languageapp.R
import com.example.languageapp.domain.models.LanguageModel
import com.example.languageapp.domain.models.OnboardingItem

object Constants {
    val onboardingItems = listOf(
        OnboardingItem(
            image = R.drawable.onb1,
            title = "Confidence in your words",
            description = "With conversation-based learning,\nyou'll be talking from lesson one"
        ),
        OnboardingItem(
            image = R.drawable.onb2,
            title = "Take your time to learn",
            description = "Develop a habit of learning and\nmake it a part of your daily routine"
        ),
        OnboardingItem(
            image = R.drawable.onb3,
            title = "The lessons you need to learn",
            description = "Using a variety of learning styles to learn\nand retain"
        )
    )

    val languageCodes = listOf(
        LanguageModel(fullName = "Russian", shortName = "ru"),
        LanguageModel(fullName = "English", shortName = "en"),
        LanguageModel(fullName = "Chinese", shortName = "ch"),
        LanguageModel(fullName = "Belarus", shortName = "by"),
        LanguageModel(fullName = "Kazakh", shortName = "kz")
    )
}