package com.example.languageapp.common

import com.example.languageapp.R
import com.example.languageapp.domain.models.AnimalModel
import com.example.languageapp.domain.models.GuessWordModel
import com.example.languageapp.domain.models.LanguageModel
import com.example.languageapp.domain.models.LeaderBoardModel
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

    val animals = listOf(
        AnimalModel(
            imageLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnlTj8sKzZV6zMBEvlXsDzk_rYE8X3Mxtl7A&s",
            name = "racoon"
        ),
        AnimalModel(
            imageLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLYc_A5hDN5q4Z-zgAvZfbsBle4eAH5jWKLg&s",
            name = "dog"
        ),
        AnimalModel(
            imageLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnI2ntBho54ez618D93QJznPP2J1hDJUYkrQ&s",
            name = "cat"
        ),
    )
    
    val wordsToGuess = listOf(
        GuessWordModel(
            word = "gardener",
            transcription = "[ 'gɑ:dnə ]",
            translation = "садовник"
        ),
        GuessWordModel(
            word = "fly",
            transcription = "[ flai ]",
            translation = "муха"
        ),
        GuessWordModel(
            word = "dog",
            transcription = "[ dəg ]",
            translation = "собака"
        )
    )

    val randomRussianWords = listOf("жопа", "школа", "учитель", "олимпиала", "подосиновик", "гриб", "лес")
    val randomEnglishWordsToGuess = listOf("school", "ass", "teacher", "olympiad", "podosynovik", "mashroom", "forest")

    val dataForWidget = listOf(
        LeaderBoardModel(5, "Vincent van Gogh", 12),
        LeaderBoardModel(6, "Vincent van Gogh", 12),
        LeaderBoardModel(7, "You", 12, isYou = true),
        LeaderBoardModel(8, "Vincent van Gogh", 12),
    )
}
