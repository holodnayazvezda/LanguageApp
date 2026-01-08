package com.example.languageapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = dark,
    onBackground = white,
    surface = blue,
    onSurface = white,
    primary = deepBlue,
    onPrimary = white
)

private val LightColorScheme = lightColorScheme(
    background = white,
    onBackground = dark,
    surface = blue,
    onSurface = white,
    primary = deepBlue,
    onPrimary = white
)

@Composable
fun LanguageAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}