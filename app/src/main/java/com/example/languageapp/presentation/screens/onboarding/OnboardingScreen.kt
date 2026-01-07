package com.example.languageapp.presentation.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.languageapp.common.Constants
import com.example.languageapp.presentation.components.AppButton
import com.example.languageapp.presentation.theme.fredokaFontFamily
import com.example.languageapp.presentation.theme.orange
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    navigateToNextScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(160.dp))
        val pagerState = rememberPagerState(pageCount = {3})
        val scope = rememberCoroutineScope()

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { i ->
            val currentItem = Constants.onboardingItems[i]
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(currentItem.image),
                    contentDescription = null,
                    modifier = Modifier.size(270.dp),
                    tint = Color.Unspecified
                )
                Spacer(Modifier.height(40.dp))
                Row(
                    Modifier
                        .wrapContentHeight()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color = if (pagerState.currentPage == iteration) orange
                        else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f)
                        Box(
                            modifier = Modifier
                                .padding(5.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(8.dp)
                        )
                    }
                }
                Spacer(Modifier.height(20.dp))
                Text(
                    text = currentItem.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = currentItem.description,
                    fontFamily = fredokaFontFamily,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(110.dp))
            }
        }
        AppButton(
            text = if (pagerState.currentPage == 0) {
                "Next"
            } else if (pagerState.currentPage == 1) {
                "More"
            } else {
                "Choose a language"
            },
            onClick = {
                if (pagerState.currentPage < 2) {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                } else {
                    navigateToNextScreen()
                }
            }
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = "Skip onboarding",
            fontFamily = fredokaFontFamily,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

    }
}