package com.example.languageapp.data.storage

import android.content.Context

open class Storage(
    context: Context,
    sharedPreferencesName: String,
) {
    private val sharedPreferences = context.getSharedPreferences(
        sharedPreferencesName,
        Context.MODE_PRIVATE
    )

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    fun putString(key: String, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getInteger(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun putInteger(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }
}