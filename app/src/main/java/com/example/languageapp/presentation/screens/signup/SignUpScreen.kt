package com.example.languageapp.presentation.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.AppTextField
import com.example.languageapp.presentation.components.ScreenDefaultTopAppBor
import com.example.languageapp.presentation.theme.blue
import com.example.languageapp.presentation.theme.greyDark

@Composable
fun SignUpScreen(
    navigateBack: () -> Unit,
    navigateToCreatePasswordScreen: () -> Unit,
    viewModel: SignUpScreenViewModel
) {
    val signUpState = viewModel.signUpModel.collectAsState().value

    Scaffold(
        topBar = {
            ScreenDefaultTopAppBor(
                title = "Signup",
                navigateToPreviousScreen = navigateBack
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).padding(horizontal = 20.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(40.dp))
            Text(
                text = "Create an Account",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(30.dp))
            AppTextField(
                name = "First Name",
                placeholder = "Your First Name",
                onValueChange = { viewModel.updateData(firstName = it) },
                value = signUpState.firstName
            )
            Spacer(Modifier.height(20.dp))
            AppTextField(
                name = "Last Name",
                placeholder = "Your Last Name",
                onValueChange = { viewModel.updateData(lastName = it) },
                value = signUpState.lastName
            )
            Spacer(Modifier.height(20.dp))
            AppTextField(
                name = "Email Address",
                placeholder = "Email",
                onValueChange = { viewModel.updateData(email = it) },
                value = signUpState.email,
                isPassword = true
            )
            Spacer(Modifier.height(30.dp))
            AppButton(
                text = "Continue",
                onClick = navigateToCreatePasswordScreen
            )
            Spacer(Modifier.height(25.dp))
            Row{
                Text(
                    text = "Already you member?",
                    color = greyDark,
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 17.sp
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = "Login",
                    color = blue,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 17.sp,
                    modifier = Modifier.clickable {
                        navigateBack()
                    }
                )
            }
        }
    }
}