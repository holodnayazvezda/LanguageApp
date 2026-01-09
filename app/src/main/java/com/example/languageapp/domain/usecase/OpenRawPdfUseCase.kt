package com.example.languageapp.domain.usecase

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

class OpenRawPdfUseCase(
    val context: Context
) {
    operator fun invoke(rawResId: Int, fileName: String) {
        try {
            val inputStream = context.resources.openRawResource(rawResId)
            val file = File(context.cacheDir, fileName)

            val outputStream = FileOutputStream(file)
            inputStream.copyTo(outputStream)
            outputStream.close()
            inputStream.close()
            val uri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.provider",
                file
            )

            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, "application/pdf")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }

            context.startActivity(intent)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}