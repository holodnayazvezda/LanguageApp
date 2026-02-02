package com.example.languageapp.presentation.navigation

enum class NavigationRoutes(
    val route: String
) {
    SPLASH_SCREEN("splash"),
    ONBOARDING_SCREEN("onboarding"),
    LANGUAGE_SELECT_SCREEN("language_select"),
    SIGN_UP_SCREEN("sign_up_screen"),
    CREATE_PASSWORD_SCREEN("create_password_screen"),
    LOG_IN_SCREEN("log_in_screen"),
    MAIN_SCREEN("main_screen"),
    AUDITION_EXERCISE("audition"),
    GAME_EXERCISE("game"),
    GUESS_ANIMAL_EXERCISE("guess_animal"),
    CORRECT_ANSWER_SCREEN("correct_answer"),
    WRONG_ANSWER_SCREEN("wrong_answer"),
    WORD_PRACTICE_EXERCISE("word_practice"),
    PROFILE("profile"),
    CHOOSE_IMAGE("choose_image")
}