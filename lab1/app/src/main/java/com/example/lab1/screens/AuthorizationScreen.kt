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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun Auth_Prev() {
    Column(
        modifier = Modifier.fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.Red)
    )
    {

        Spacer(modifier = Modifier.height(300.dp))

        // логин
        Box(
            modifier = Modifier.background(color = Color.Blue)
                .fillMaxWidth()
        )
        {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row { TextField(value = "Введите логин", onValueChange = {}) }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))


        // пароль
        Box(
            modifier = Modifier.background(color = Color.Blue)
                .fillMaxWidth()
        )
        {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row { TextField(value = "Введите пароль", onValueChange = {}) }
            }
        }


        Spacer(modifier = Modifier.height(50.dp))


        // войти
        Box(
            modifier = Modifier.background(color = Color.Blue)
                .fillMaxWidth()
        )
        {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {} ) { Text(text = "Войти") }
            }
        }


                Spacer(modifier = Modifier.height(50.dp))



                Box(
                    modifier = Modifier
                        .background(color = Color.Blue)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Button(onClick = { /* TODO: обработка регистрации */ }) {
                                Text("Регистрация")
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Button(onClick = { /* TODO: обработка восстановления пароля */ }) {
                                Text("Забыл пароль")
                            }
                        }
                    }
                }


            }
        }
