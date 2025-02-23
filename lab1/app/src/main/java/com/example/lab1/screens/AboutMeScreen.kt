package com.example.lab1.screens

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


@Preview(showBackground = true)
@Composable
fun About_me_Prev() {

    About_me()
}


@Composable
fun About_me() {
    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .background(Color.Red)
                    .weight(1f)
            ) {
                Button(onClick = {},) {   Text(text = "Поиск", color = Color.White)}

            }

            Column(
                modifier = Modifier
                    .background(Color.Blue)
                    .weight(1f)
            ) {
                Button(onClick = {},) {   Text(text = "Обновить данные", color = Color.White)}
            }
        }


        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp)
        ) {

            Spacer(modifier = Modifier.height(15.dp))
           TextField(value = "Default", onValueChange ={} )

            Spacer(modifier = Modifier.height(15.dp))
            TextField(value = "Default", onValueChange ={} )

            Spacer(modifier = Modifier.height(15.dp))
            TextField(value = "Default", onValueChange ={} )

            Spacer(modifier = Modifier.height(15.dp))
            TextField(value = "Default", onValueChange ={} )

            Spacer(modifier = Modifier.height(15.dp))
            TextField(value = "Default", onValueChange ={} )

        }
    }
}