package com.example.lab1.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun Registration_prev(){
    val nav_controller= rememberNavController()
    Registration(nav_controller)

}



@Composable
fun Registration(nav_controller: NavController){
    Column(modifier = Modifier.fillMaxSize().padding(25.dp))
    {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Приветствуем вас на экране регистрации!",
                textAlign = TextAlign.Center
            )
        }


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



            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {nav_controller.navigate("To_Auth_prev")}) { Text(text="Зарегестрироваться") }

        }

    }


}