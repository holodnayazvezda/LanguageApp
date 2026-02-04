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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.languageapp.R
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
                title = stringResource(R.string.signup),
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
                text = stringResource(R.string.choose_password),
                style = MaterialTheme.typography.titleMedium,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(30.dp))
            AppTextField(
                name = stringResource(R.string.password),
                placeholder = "●●●●●●●",
                onValueChange = { viewModel.updateData(password = it) },
                value = signUpState.password,
                isPassword = true
            )
            Spacer(Modifier.height(25.dp))
            AppTextField(
                name = stringResource(R.string.confirm_password),
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
                        withStyle(SpanStyle(color = blue)) {
                            append(stringResource(R.string.i_have_made))
                        }
                    }
                    Text(
                        text = annotatedString,
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 17.sp,
                        modifier = Modifier.clickable {
                            viewModel.openPdf(R.raw.policy, "policy.pdf")
                        }
                    )
                }
                Row(Modifier.fillMaxWidth()) {
                    val annotatedString = buildAnnotatedString {
                        withStyle(SpanStyle(color = blue)) {
                            append(stringResource(R.string.the_rules))
                        }
                        append(" " + stringResource(R.string.accept_provisions))
                    }
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = annotatedString,
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 17.sp,
                        modifier = Modifier.clickable {
                            viewModel.openPdf(R.raw.policy, "policy.pdf")
                        }
                    )
                }
            }
            Spacer(Modifier.height(80.dp))
            AppButton(
                text = stringResource(R.string.signup),
                onClick = {
                    viewModel.register(navigateToLogin)
                }
            )
            Spacer(Modifier.height(30.dp))
            Row{
                Text(
                    text = stringResource(R.string.already_member),
                    color = greyDark,
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 17.sp
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string.login),
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
            title = stringResource(R.string.error),
            text = signUpState.errorResId?.let { stringResource(it) } ?: ""
        )
    }
}