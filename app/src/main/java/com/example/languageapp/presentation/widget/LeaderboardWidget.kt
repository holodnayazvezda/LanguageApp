package com.example.languageapp.presentation.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import com.example.languageapp.data.storage.AppStorage
import org.koin.compose.getKoin

class LeaderboardWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val vm = LeaderboardWidgetViewModel(appStorage = AppStorage(context))

        provideContent{
            GlanceTheme {
                LeaderboardContent(vm)
            }
        }
    }
}
