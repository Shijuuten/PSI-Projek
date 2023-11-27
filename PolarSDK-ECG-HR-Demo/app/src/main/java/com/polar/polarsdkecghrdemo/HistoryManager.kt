package com.polar.polarsdkecghrdemo

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HistoryManager(private val context: Context) {
    companion object {
        private const val PREFS_NAME = "HistoryPrefs"
        private const val HISTORY_KEY = "history_list"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveHistory(historyList: List<String>) {
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(historyList)
        editor.putString(HISTORY_KEY, json)
        editor.apply()
    }

    fun loadHistory(): List<String> {
        val json = sharedPreferences.getString(HISTORY_KEY, "")
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, type) ?: listOf()
    }
}
