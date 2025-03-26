package com.example.lab1.screens

import android.widget.Switch
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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lab1.R
import com.example.lab1.ui.theme.Lab1Theme


@Preview(showBackground = true)
@Composable
fun MainScreen_prev()
{
    val nav_controller= rememberNavController()
    MainScreen(nav_controller)}



@Composable
fun MainScreen(nav_controller:NavController) {


    var isDarkTheme by rememberSaveable { mutableStateOf(false) }

    // Устанавливаем тему в зависимости от состояния переключателя
    Lab1Theme(darkTheme = isDarkTheme) {


        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(60.dp))






            // Переключатель темы
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(onClick = {
                    isDarkTheme = !isDarkTheme
                }) { Text(text = "Переключение темы") }
            }







            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    Button(onClick = { nav_controller.navigate("To_SearchSettings") })
                    { Text(text = "Поиск вкансий") };

                    Button(onClick = { nav_controller.navigate("To_About_me") })
                    { Text(text = "Обновить данные") }

                    Spacer(modifier = Modifier.height(40.dp))


                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Name")
                }
                Spacer(modifier = Modifier.height(20.dp))
                ImageScreen()

                Spacer(modifier = Modifier.height(40.dp))
                Vacancy_Response()


                Spacer(modifier = Modifier.height(200.dp))
                Button(onClick = { nav_controller.navigate("To_Auth_prev") }) { Text(text = "Выйти") }
            }
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
    Column(modifier = Modifier.padding(25.dp)) {
        Text("Отклик по вакансии 1");
        Text("Отклик по вакансии 2")

    }



}