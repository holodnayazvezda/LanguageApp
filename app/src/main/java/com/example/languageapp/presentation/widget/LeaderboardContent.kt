package com.example.languageapp.presentation.widget

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.example.languageapp.presentation.theme.dark
import com.example.languageapp.presentation.theme.deepBlue
import com.example.languageapp.presentation.theme.ultraLightGrey
import com.example.languageapp.presentation.theme.white

@SuppressLint("RestrictedApi")
@Composable
fun LeaderboardContent(viewModel: LeaderboardWidgetViewModel) {
    val leaders = viewModel.leaders.collectAsState().value
    Column(
        modifier = GlanceModifier.fillMaxWidth().height(265.dp).padding(horizontal = 20.dp).background(
            deepBlue
        )
    ) {
        Spacer(GlanceModifier.height(20.dp))
        Text(
            text = "You place is 7! Awesome!",
            style = TextStyle(
                color = ColorProvider(white),
                fontFamily = fredokaMedium,
                fontSize = 22.sp
            )
        )
        Spacer(GlanceModifier.height(10.dp))
        LazyColumn(
            modifier = GlanceModifier.fillMaxWidth(),
        ) {
            items(items = leaders) { item ->
                Row(
                    GlanceModifier
                    .fillMaxWidth()
                    .height(38.dp)
                        .padding(horizontal = 12.dp).background(ColorProvider(ultraLightGrey)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.name,
                        style = TextStyle(
                            color = ColorProvider(dark),
                            fontFamily = fredokaMedium,
                            fontSize = 17.sp
                        )
                    )
                }
            }
        }
    }
}