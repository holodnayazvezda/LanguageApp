package com.example.languageapp.common

import com.example.languageapp.R
import com.example.languageapp.domain.models.LanguageModel
import com.example.languageapp.domain.models.OnboardingItem

object Constants {
    val onboardingItems = listOf(
        OnboardingItem(
            image = R.drawable.onb1,
            titleResId = R.string.onboarding_title_1,
            descriptionResId = R.string.onboarding_desc_1
        ),
        OnboardingItem(
            image = R.drawable.onb2,
            titleResId = R.string.onboarding_title_2,
            descriptionResId = R.string.onboarding_desc_2
        ),
        OnboardingItem(
            image = R.drawable.onb3,
            titleResId = R.string.onboarding_title_3,
            descriptionResId = R.string.onboarding_desc_3
        )
    )

    val languageCodes = listOf(
        LanguageModel(nameResId = R.string.lang_russian, shortName = "ru"),
        LanguageModel(nameResId = R.string.lang_english, shortName = "en"),
        LanguageModel(nameResId = R.string.lang_chinese, shortName = "zh"),
        LanguageModel(nameResId = R.string.lang_belarusian, shortName = "be"),
        LanguageModel(nameResId = R.string.lang_kazakh, shortName = "kk")
    )
}