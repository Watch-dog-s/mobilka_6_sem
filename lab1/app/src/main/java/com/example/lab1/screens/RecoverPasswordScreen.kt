package com.example.lab1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun Recovery_Password_prev(){
    val nav_controller= rememberNavController()
    Recovery_Password(nav_controller)


}

@Composable
fun Recovery_Password(nav_controller: NavController){

    Column(modifier = Modifier.fillMaxSize().padding(45.dp)) {

        Text(text = "Восстановление пароля");

        Spacer(modifier = Modifier.height(15.dp))
        TextField(value = "Почта", onValueChange ={} )


        Spacer(modifier = Modifier.height(15.dp))
        TextField(value = "Почта", onValueChange ={} )


        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {nav_controller.navigate("To_Auth_prev")}) { Text(text="Восстановить") }


    }


}