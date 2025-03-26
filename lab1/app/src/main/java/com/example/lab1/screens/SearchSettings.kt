package com.example.lab1.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab1.SharedPreferences.SearchHistoryManager
import com.example.lab1.ViewModel.SearchSettingViewModel
import kotlinx.coroutines.delay



@Preview(showBackground = true)
@Composable
fun SearchSettings_prev() {
    val nav_controller= rememberNavController()
    //SearchSettings(nav_controller)
}



@Composable
fun SearchSettings(navController: NavController,SearchViewModel1:SearchSettingViewModel) {



    var vacancy by rememberSaveable { mutableStateOf("") }
    var direction by rememberSaveable { mutableStateOf("") }
    var position by rememberSaveable { mutableStateOf("") }
    var experience by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val searchHistoryManager = remember { SearchHistoryManager(context) }


    var history by remember { mutableStateOf(searchHistoryManager.getHistory()) }



    // Запускаем автоматический поиск
    AutoSearch(navController, SearchViewModel1, vacancy)


    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Настройки поиска")
//
//        TextField(
//            value = vacancy,
//            onValueChange = {vacancy=it},
//            placeholder = { Text(text = "Введите вакансию") },
//            trailingIcon = {
//                if (vacancy.isNotEmpty()) {
//                   Button(onClick = {vacancy=""}) { Text(text="Очистить") }
//                }
//            },
//            singleLine = true
//        )


        // Поле ввода с историей
        SearchField(vacancy, onVacancyChange = { vacancy = it }, searchHistory, addToHistory)

        Spacer(modifier = Modifier.height(15.dp))


















        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = direction,
            onValueChange = { direction = it },
            placeholder = { Text(text = "Введите направление") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = position,
            onValueChange = { position = it },
            placeholder = { Text(text = "Введите должность") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = experience,
            onValueChange = { experience = it },
            placeholder = { Text(text = "Введите стаж") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(onClick = { navController.navigate("To_All_Vacancy",)

                SearchViewModel1.update_vacancy(vacancy)
                Log.i("Search_Vacancy",  SearchViewModel1.get_vacancy().toString()  )

            })
            {
                Text(text = "Поиск")
            }

            Button(onClick = { navController.navigate("To_home") }) {
                Text(text = "Домой")
            }
        }
    }
}




@Composable
fun AutoSearch(navController: NavController, searchViewModel: SearchSettingViewModel, query: String) {
    val coroutineScope = rememberCoroutineScope()
    val lastInputTime = remember { mutableStateOf(System.currentTimeMillis()) }

    // Запускаем эффект, который сбрасывает таймер при каждом изменении запроса
    LaunchedEffect(query) {
        lastInputTime.value = System.currentTimeMillis()
        delay(15_000) // Ожидание 15 секунд
        if (System.currentTimeMillis() - lastInputTime.value >= 15_000) {
            searchViewModel.update_vacancy(query)
            navController.navigate("To_All_Vacancy")
        }
    }
}









@Composable
fun SearchField(
    vacancy: String,
    onVacancyChange: (String) -> Unit,
    searchHistory: List<String>,
    addToHistory: (String) -> Unit
) {
    // Поле ввода с историей
    TextField(
        value = vacancy,
        onValueChange = onVacancyChange,
        placeholder = { Text(text = "Введите вакансию") },
        trailingIcon = {
            if (vacancy.isNotEmpty()) {
                Button(onClick = { onVacancyChange("") }) { Text(text = "Очистить") }
            }
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Показать историю при нажатии на текстовое поле
                if (searchHistory.isNotEmpty()) {
                    onVacancyChange(searchHistory.first())  // Показываем первую запись в истории
                }
            }
    )

    // Показать историю поиска, если она существует и не пустая
    if (searchHistory.isNotEmpty()) {
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Text("История поиска:")
            LazyColumn {
                items(searchHistory) { historyItem ->
                    Text(
                        text = historyItem,
                        modifier = Modifier
                            .clickable {
                                onVacancyChange(historyItem) // При нажатии на элемент из истории, добавляем его в строку поиска
                                addToHistory(historyItem) // Добавляем в историю
                            }
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}