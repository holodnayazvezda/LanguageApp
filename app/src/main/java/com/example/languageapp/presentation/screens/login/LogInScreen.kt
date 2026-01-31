package com.example.languageapp.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.components.AppTextField
import com.example.languageapp.presentation.components.InfoDialog
import com.example.languageapp.presentation.components.ScreenDefaultTopAppBor
import com.example.languageapp.presentation.theme.blue
import com.example.languageapp.presentation.theme.greyDark
import com.example.languageapp.presentation.theme.red
import okio.inMemorySocketPair

@Composable
fun LogInScreen(
    navigateBack: () -> Unit,
    navigateToMainScreen: () -> Unit,
    navigateToSignUp: () -> Unit,
    viewModel: LogInViewModel
) {
    val logInState = viewModel.logInModel.collectAsState()
    Scaffold(
        topBar = {
            ScreenDefaultTopAppBor(
                title = stringResource(R.string.login),
                navigateToPreviousScreen = navigateBack
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(25.dp))
            Image(
                painter = painterResource(R.drawable.learn_at_home),
                contentDescription = null,
                modifier = Modifier.width(105.dp).height(82.dp)
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = stringResource(R.string.login_subtitle),
                style = MaterialTheme.typography.titleMedium,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(35.dp))
            AppTextField(
                name = stringResource(R.string.email_address),
                placeholder = stringResource(R.string.email),
                onValueChange = { viewModel.updateData(email = it) },
                value = logInState.value.email,
                isPassword = false
            )
            Spacer(Modifier.height(25.dp))
            AppTextField(
                name = stringResource(R.string.password),
                placeholder = stringResource(R.string.password_placeholder),
                onValueChange = { viewModel.updateData(password = it) },
                value = logInState.value.password,
                isPassword = true
            )
            Spacer(Modifier.height(12.dp))
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.forgot_password),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 15.sp,
                    color = red
                )
            }
            Spacer(Modifier.height(32.dp))
            AppButton(
                text = stringResource(R.string.login),
                onClick = {
                    if (!viewModel.checkOnErrors()) {
                        navigateToMainScreen()
                    }
                }
            )
            Spacer(Modifier.height(30.dp))
            Row{
                Text(
                    text = stringResource(R.string.not_a_member),
                    color = greyDark,
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 17.sp
                )
                Spacer(Modifier.width(3.dp))
                Text(
                    text = stringResource(R.string.signup),
                    color = blue,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 17.sp,
                    modifier = Modifier.clickable {
                        navigateToSignUp()
                    }
                )
            }
        }
    }

    if (logInState.value.isError) {
        InfoDialog(
            onConfirm = { viewModel.readError() },
            title = stringResource(R.string.error),
            text = logInState.value.errorResId?.let { stringResource(it) } ?: ""
        )
    }
}