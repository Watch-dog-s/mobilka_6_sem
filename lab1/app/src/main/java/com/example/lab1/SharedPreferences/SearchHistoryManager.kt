package com.example.lab1.SharedPreferences

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi



class SearchHistoryManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("search_history", Context.MODE_PRIVATE)


    fun getSearchHistory(): List<String> {
        val history = sharedPreferences.getStringSet("history", emptySet()) ?: emptySet()
        return history.toList()
    }

    // Добавляем новый запрос в историю
    fun addSearchQuery(query: String) {
        val currentHistory = LinkedHashSet(getSearchHistory()) //  LinkedHashSet для сохранения порядка

        if (!currentHistory.contains(query)) {
            currentHistory.add(query) // Добавляем в конец списка
        }

        if (currentHistory.size > 10) {
            currentHistory.remove(currentHistory.first()) // Убираем самый старый элемент
        }

        sharedPreferences.edit().putStringSet("history", currentHistory).commit() // commit() для мгновенного сохранения
    }



    fun deleteSearchHistory() {
        sharedPreferences.edit().remove("history").apply()
    }
}
