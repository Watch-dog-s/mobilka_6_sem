package com.example.lab1.screens

import android.content.Context
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun About_me_Prev() {

    val nav_controller= rememberNavController()
    About_me(nav_controller)
}


@Composable
fun About_me(nav_controller:NavController) {
    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Button(onClick = {nav_controller.navigate("To_SearchSettings")},) {   Text(text = "Поиск", color = Color.White)}

            }

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Button(onClick = {nav_controller.navigate("To_About_me")},) {   Text(text = "Обновить данные", color = Color.White)}
            }
        }


        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp)
        ) {

            Spacer(modifier = Modifier.height(15.dp))
           TextField(value = "ФИО", onValueChange ={} )

            Spacer(modifier = Modifier.height(15.dp))
            TextField(value = "Образование", onValueChange ={} )

            Spacer(modifier = Modifier.height(15.dp))
            TextField(value = "Специальность", onValueChange ={} )

            Spacer(modifier = Modifier.height(15.dp))
            TextField(value = "Номер телефона", onValueChange ={} )

            Spacer(modifier = Modifier.height(15.dp))
            TextField(value = "Почта", onValueChange ={} )

        }
    }
}