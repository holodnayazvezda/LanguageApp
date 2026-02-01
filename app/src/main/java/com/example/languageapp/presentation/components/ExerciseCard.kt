package com.example.languageapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExerciseCard(
    imageResId: Int,
    name: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(153.dp)
            .height(117.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(backgroundColor)
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(6.dp))
        Image(
            painter = painterResource(imageResId),
            contentDescription = null,
            modifier = Modifier.width(90.dp).height(80.dp)
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = name,
            color = Color.White,
            style = MaterialTheme.typography.titleSmall,
            fontSize = 13.sp,
        )
    }
}