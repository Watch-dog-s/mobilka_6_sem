package com.example.lab1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab1.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable
fun All_Vacancy_prev()
{
    val nav_controller= rememberNavController()
    All_Vacancy(nav_controller)

}



@Composable
fun All_Vacancy(nav_controller: NavController)
{
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.height(50.dp))
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp))
        { Button(onClick = {nav_controller.navigate("To_All_Vacancy")}) { Text(text="Поиск вакансий") };
            Button(onClick = {nav_controller.navigate("To_home")}) { Text(text="Домой") } }

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy(nav_controller)

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy(nav_controller)

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy(nav_controller)

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy(nav_controller)

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy(nav_controller)
    }

}



@Composable
fun Vacancy(nav_controller: NavController){
    Column(modifier = Modifier.fillMaxWidth().clickable(onClick = {nav_controller.navigate("To_vacancy")}))
    {
        Row {


            Text(text="Название компании")
        }

        Row {

            Image(
                painter = painterResource(id = R.drawable.job),
                contentDescription = "Тут будет аватар компании",
                modifier = Modifier.size(50.dp)
            )

            Text(text="Описание вакансии тут МНОООООГО текста ")
        }
}
}