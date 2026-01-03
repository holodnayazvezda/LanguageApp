package com.example.languageapp.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.R
import com.example.languageapp.presentation.navigation.NavigationRoutes
import com.example.languageapp.presentation.theme.deepBlue
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToNextScreen: (route: String) -> Unit
) {
    LaunchedEffect(Unit) {
        delay(1000)
        navigateToNextScreen(NavigationRoutes.ONBOARDING_SCREEN.route)
    }
    Box(
        modifier = Modifier.fillMaxSize().background(deepBlue),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = null,
                modifier = Modifier.size(160.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Language App",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 42.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}