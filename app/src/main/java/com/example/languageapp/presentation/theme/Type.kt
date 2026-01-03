package com.example.languageapp.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.languageapp.R

val fredokaFontFamily = FontFamily(
    Font(R.font.fredoka, FontWeight.Normal),
    Font(R.font.fredoka, FontWeight.Bold),
    Font(R.font.fredoka, FontWeight.SemiBold),
    Font(R.font.fredoka, FontWeight.Medium),
)

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = fredokaFontFamily,
        fontWeight = FontWeight.Medium
    ),
    titleLarge = TextStyle(
        fontFamily = fredokaFontFamily,
        fontWeight = FontWeight.SemiBold

    ),
    headlineLarge = TextStyle(
        fontFamily = fredokaFontFamily,
        fontWeight = FontWeight.Bold
    )
)