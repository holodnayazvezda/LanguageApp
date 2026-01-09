package com.example.languageapp.presentation.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.AppTextField
import com.example.languageapp.presentation.components.InfoDialog
import com.example.languageapp.presentation.components.ScreenDefaultTopAppBor
import com.example.languageapp.presentation.theme.blue
import com.example.languageapp.presentation.theme.greyDark

@Composable
fun CreatePasswordScreen(
    navigateBack: () -> Unit,
    navigateToLogin: () -> Unit,
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
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(40.dp))
            Text(
                text = "Choose a Password",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(30.dp))
            AppTextField(
                name = "Password",
                placeholder = "●●●●●●●",
                onValueChange = { viewModel.updateData(password = it) },
                value = signUpState.password,
                isPassword = true
            )
            Spacer(Modifier.height(25.dp))
            AppTextField(
                name = "Confirm Password",
                placeholder = "●●●●●●●",
                onValueChange = { viewModel.updateData(confirmPassword = it) },
                value = signUpState.confirmPassword,
                isPassword = true
            )
            Spacer(Modifier.height(20.dp))
            Column(Modifier.fillMaxWidth()) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = signUpState.confirmUserAgreement,
                        onCheckedChange = { viewModel.updateData(confirmUserAgreement = it) },
                        colors = CheckboxDefaults.colors(
                            checkedColor = blue,
                            uncheckedColor = blue
                        )
                    )
                    Spacer(Modifier.width(5.dp))
                    val annotatedString = buildAnnotatedString {
                        append("I ")
                        withStyle(SpanStyle(color = blue)) {
                            append("have made myself acquainted with")
                        }
                    }
                    Text(
                        text = annotatedString,
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 17.sp
                    )
                }
                Row(Modifier.fillMaxWidth()) {
                    val annotatedString = buildAnnotatedString {
                        withStyle(SpanStyle(color = blue)) {
                            append("the Rules")
                        }
                        append(" and accept all its provisions,")
                    }
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = annotatedString,
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 17.sp
                    )
                }
            }
            Spacer(Modifier.height(80.dp))
            AppButton(
                text = "Signup",
                onClick = {
                    if (!viewModel.checkOnErrors(true)) {
                        navigateToLogin()
                    }
                }
            )
            Spacer(Modifier.height(30.dp))
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

    if (signUpState.isError) {
        InfoDialog(
            onConfirm = { viewModel.readError() },
            title = "Error",
            text = signUpState.errorText
        )
    }
}