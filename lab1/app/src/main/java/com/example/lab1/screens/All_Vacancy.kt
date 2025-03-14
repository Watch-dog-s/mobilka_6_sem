package com.example.lab1.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab1.R
import com.example.lab1.Retrofit.RetrofitClient
import com.example.lab1.Retrofit.Vacancy
import com.example.lab1.Retrofit.VacancyAPI
import com.example.lab1.ViewModel.SearchSettingViewModel
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable
fun All_Vacancy_prev()
{
    val nav_controller= rememberNavController()
  //  All_Vacancy(nav_controller)

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun All_Vacancy(navController: NavController,SeacrchViewModel1:SearchSettingViewModel) {



    var vacancies by rememberSaveable { mutableStateOf<List<Vacancy>>(emptyList()) }
    var isError by rememberSaveable { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {

                Log.d("Search_Vacancy1",SeacrchViewModel1.get_vacancy().toString() )
                val response = RetrofitClient.instance.create(VacancyAPI::class.java).getVacancies(query= SeacrchViewModel1.get_vacancy().toString())


                vacancies = response.items
                isError = false

                Log.d("VacancyItem", "Vacancy ID: ${vacancies[0].id}")
                Log.d("VacancyItem", "Vacancy ID: ${vacancies[1].id}")
                Log.d("VacancyItem", "Vacancy ID: ${vacancies[2].id}")
                Log.d("VacancyItem", "Vacancy ID: ${vacancies[3].id}")

            } catch (e: Exception) {
                e.printStackTrace()
                isError = true
            }
        }

    }

    Scaffold(
        topBar = {
           // isError=true
            TopAppBar(
                title = { Text("Все вакансии") },
                actions = {
                    Button(onClick = { navController.navigate("To_SearchSettings") }) {
                        Text(text = "Поиск")
                    }
                    Button(onClick = { navController.navigate("To_home") }) {
                        Text(text = "Домой")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                isError -> {
                    Text("Ошибка загрузки данных", color = Color.Red, fontSize = 18.sp)
                }
                vacancies.isEmpty() -> {
                    Text("Ничего не найдено", fontSize = 18.sp)
                }
                else -> {
                    LazyColumn {
                        items(vacancies) { vacancy ->
                            VacancyItem(vacancy,navController)
                        }
                    }
                }
            }
        }
    }
}





@Composable
fun VacancyItem(vacancy: Vacancy,navController:NavController) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp).clickable(onClick = {navController.navigate("To_vacancy") })) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = vacancy.name)
            vacancy.description?.let {
                Text(text = it)
            }
        }
    }



}