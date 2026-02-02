package com.example.languageapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R
import com.example.languageapp.presentation.theme.white

@Composable
fun GameTopAppBar(
    navigateBack: () -> Unit,
    title: String,
    background: Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(background)
            .padding(horizontal = 25.dp)
    ) {
        Spacer(Modifier.height(44.dp))
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navigateBack()
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = null,
                    tint = white,
                    modifier = Modifier.width(17.dp).height(27.dp)
                )
            }
            Spacer(Modifier.width(25.dp))
            Text(
                text = title,
                color = white,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 22.sp
            )
        }
    }
}