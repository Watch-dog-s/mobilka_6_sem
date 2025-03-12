package com.example.lab1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.lab1.navigation.navigation
import com.example.lab1.ui.theme.Lab1Theme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.lifecycleScope
import com.example.lab1.Retrofit.VacancyAPI
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            navigation(navController)
        }



        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.hh.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val jobApi = retrofit.create(VacancyAPI::class.java)

        lifecycleScope.launch {
            try {
                val response = jobApi.getVacancies()
                response.items.forEach {
                    Log.d("Vacancy", "Название: ${it.name}, Описание: ${it.description}")
                }
            } catch (e: Exception) {
                Log.e("Vacancy", "Ошибка загрузки: ${e.message}")
            }
        }

    }



}






