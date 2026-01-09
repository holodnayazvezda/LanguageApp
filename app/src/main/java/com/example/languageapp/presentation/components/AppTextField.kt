package com.example.languageapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R

@Composable
fun AppTextField(
    name: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    value: String,
    isPassword: Boolean = false
) {
    var isShown by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 15.sp
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(15.dp),
            placeholder = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.titleSmall,
                    color =  MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                    fontSize = 15.sp
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.05f),
                unfocusedContainerColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.05f),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor =  MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            singleLine = true,
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = { isShown = !isShown }) {
                        Icon(
                            painter = painterResource(R.drawable.eye),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            },
            visualTransformation = if (isPassword && !isShown) PasswordVisualTransformation('●') else VisualTransformation.None
        )
    }
}