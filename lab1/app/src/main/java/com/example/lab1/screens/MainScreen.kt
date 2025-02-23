package com.example.lab1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1.R


@Preview(showBackground = true)
@Composable
fun MainScreen_prev(){MainScreen()}



@Composable
fun MainScreen(){
    Column (modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(40.dp))
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(onClick = {})
                { Text(text = "Поиск вкансий") };

                Button(onClick = {})
                { Text(text = "Обновить данные") }

                Spacer(modifier = Modifier.height(40.dp))



            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Name")
            }
            Spacer(modifier = Modifier.height(20.dp))
            ImageScreen()

            Spacer(modifier = Modifier.height(40.dp))
            Vacancy_Response()

        }
    }
}


@Composable
fun ImageScreen(){
    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
        Image(
            painter = painterResource(id = R.drawable.avatar), // аватар юзера
            contentDescription = "Тут аватар пользователя",
            modifier = Modifier.size(100.dp)
        )


    }
}


@Composable
fun Vacancy_Response(){
    Column {
        Text("Отклик по вакансии 1");
        Text("Отклик по вакансии 2")

    }

}