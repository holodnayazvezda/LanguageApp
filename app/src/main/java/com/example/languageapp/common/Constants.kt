package com.example.languageapp.common

import com.example.languageapp.R
import com.example.languageapp.domain.models.LanguageModel
import com.example.languageapp.domain.models.OnboardingItem
import com.example.languageapp.domain.models.TopUsersModel

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

    val topUsers = listOf(
        TopUsersModel(avatarUrl = "https://sun9-73.userapi.com/s/v1/ig2/kQb0pjVUm8-oVzMAJHW8lhEWBqUSQA8-kh40KRrncjiRrL-4Oem3eu_XAd9TaUzWxYK3qizeXHegbFve49mBnJ2J.jpg?quality=95&as=32x21,48x32,72x48,108x72,160x107,240x160,360x240,480x320,540x360,640x426,720x480,1080x720,1280x853&from=bu&cs=1280x0", name = "Vincent van Gogh", amountOfPoints = 12),
        TopUsersModel(avatarUrl = "https://sun9-55.userapi.com/s/v1/ig1/GXkSd3Mwqxa9wd1tj3IsItxDBRYBTzylv8eFDIMyOQUg95SVLaEP5glV0BKaYfaxtZOIM6-8.jpg?quality=96&as=32x43,48x64,72x96,108x144,160x213,240x320,360x480,480x640,540x720,640x853,720x960,1080x1440,1280x1707,1440x1920,1620x2160&from=bu&cs=1620x0", name = "Dmitri Ivanovich Mendeleev", amountOfPoints = 10),
        TopUsersModel(avatarUrl = "https://sun9-13.userapi.com/s/v1/ig2/ezcbOJUYu6Ozj10yc7P0UqWODMatISSRCF3saFIF5FGLbIQogzE-1Eap4t7HlrUGwiK3S7kYOBVPY_XWR2iY7mv5.jpg?quality=95&as=32x43,48x64,72x96,108x144,160x213,240x320,360x480,480x640,540x720,640x853,720x959,1080x1439,1200x1599&from=bu&cs=1200x0", name = "Vincent van Gogh", amountOfPoints = 12),
        TopUsersModel(avatarUrl = "https://sun9-79.userapi.com/s/v1/ig2/6bNf2twjHyrTrSESa3nVlFhYq3pHmU2diqn0CKLVj34OGTzIwg3daEgc9IgJOzUHHwWpW2UIgT9fhtnQ7oKkGlFY.jpg?quality=95&as=32x48,48x73,72x109,108x164,160x242,240x364,360x545,476x721&from=bu&cs=476x0", name = "Lebedeva Elena", amountOfPoints = 6),
    )
}