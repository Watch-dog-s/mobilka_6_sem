package com.example.lab1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1.R


@Preview
@Composable
fun vacancy_prev(){
    vacancy()
}


@Composable
fun vacancy(){

    Column (modifier = Modifier.fillMaxSize()){
        Row(verticalAlignment=Alignment.CenterVertically, modifier = Modifier.padding(15.dp)){

            Image(
                painter = painterResource(id = R.drawable.job),
                contentDescription = "Тут будет аватар компании",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Button(onClick = {} ) { Text("Назад") }

        }

        Row (modifier = Modifier.padding(15.dp))
        { Text(text = "Описание вакансии(Много текста)") }


        Button(onClick = {},modifier = Modifier.padding(15.dp)) { Text(text = "Откликнуться") }


    }


}