package com.example.languageapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.domain.models.LanguageModel
import com.example.languageapp.presentation.theme.dark
import com.example.languageapp.presentation.theme.lightOrange
import com.example.languageapp.presentation.theme.orange

@Composable
fun LanguageCard(
    card: LanguageModel,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (isSelected) orange
                else lightOrange
            ).clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(20.dp))
        Text(
            text = card.fullName,
            style = MaterialTheme.typography.titleMedium,
            color = dark,
            fontSize = 22.sp
        )
    }
}