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
import com.example.lab1.SharedPreferences.SearchHistoryManager
import com.example.lab1.ViewModel.SearchSettingViewModel
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val searchHistoryManager1 = SearchHistoryManager(this)

        var SearchViewModel1 = SearchSettingViewModel()
        setContent {
            val navController = rememberNavController()

            navigation(navController,SearchViewModel1,searchHistoryManager1)
        }



    }


}






