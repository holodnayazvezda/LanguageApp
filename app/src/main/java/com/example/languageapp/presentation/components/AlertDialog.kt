package com.example.languageapp.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.languageapp.presentation.theme.blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoDialog(
    onConfirm: () -> Unit,
    title: String,
    text: String
) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(
                    text = "OK",
                    color = blue
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        text = {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    )
}
