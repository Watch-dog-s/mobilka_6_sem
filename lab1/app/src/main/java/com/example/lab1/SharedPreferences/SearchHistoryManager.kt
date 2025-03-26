package com.example.lab1.SharedPreferences

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi



class SearchHistoryManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("search_history", Context.MODE_PRIVATE)

    // Метод для получения истории поиска
    fun getSearchHistory(): List<String> {
        val history = sharedPreferences.getStringSet("history", emptySet()) ?: emptySet()
        return history.toList().take(10)  // Ограничиваем историю до 10 элементов
    }

    // Метод для добавления нового элемента в историю
    fun addSearchQuery(query: String) {
        val currentHistory = getSearchHistory().toMutableList()

        if (!currentHistory.contains(query)) {
            currentHistory.add(0, query)  // Добавляем в начало списка
        }

        if (currentHistory.size > 10) {
            currentHistory.removeAt(currentHistory.size - 1)  // Убираем самый старый элемент, если история больше 10
        }

        // Сохраняем обновленную историю в SharedPreferences
        sharedPreferences.edit().putStringSet("history", currentHistory.toSet()).apply()
    }
}