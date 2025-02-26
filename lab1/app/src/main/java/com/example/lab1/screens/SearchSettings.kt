package com.example.lab1.screens

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
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun SearchSettings_prev() {
    val nav_controller= rememberNavController()
    SearchSettings(nav_controller)
}



@Composable
fun SearchSettings(nav_controller: NavController) {

    Spacer(modifier = Modifier.height(20.dp))

    val items = listOf("Элемент 1", "Элемент 2", "Элемент 3")
    val checkedState = remember { mutableStateMapOf<String, Boolean>() }
    val expanded = remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Настройки поиска",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded.value = !expanded.value }
                .padding(8.dp),
        )

        if (expanded.value) {
            items.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            checkedState[item] = !(checkedState[item] ?: false)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedState[item] ?: false,
                        onCheckedChange = {
                            checkedState[item] = it
                        }
                    )
                    Text(text = item)
                }
            }
        }


        Spacer(modifier = Modifier.height(15.dp))
        TextField(value = "Должность", onValueChange ={} )

        Spacer(modifier = Modifier.height(15.dp))
        TextField(value = "Оклад", onValueChange ={} )

        Spacer(modifier = Modifier.height(15.dp))
        TextField(value = "Адрес", onValueChange ={} )


        val items1 = listOf("Офис", "Гибрид", "Удалёнка 3")
        val checkedState1 = remember { mutableStateMapOf<String, Boolean>() }
        val expanded1 = remember { mutableStateOf(false) }


        Text(
            text = "Формат работы",
            modifier = Modifier
                .clickable { expanded1.value = !expanded1.value }
                .padding(8.dp),
        )


        if (expanded1.value) {
            items1.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            checkedState1[item] = !(checkedState1[item] ?: false)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedState1[item] ?: false,
                        onCheckedChange = {
                            checkedState1[item] = it
                        }
                    )
                    Text(text = item)
                }
            }
        }


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { nav_controller.navigate("To_All_Vacancy") }) {
                    Text(text = "Поиск")
                }

                Button(onClick = { nav_controller.navigate("To_home") }) {
                    Text(text = "Домой")
                }
            }
        }
    }
}
