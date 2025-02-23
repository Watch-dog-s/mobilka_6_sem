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
import com.example.lab1.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable
fun All_Vacancy_prev()
{
    All_Vacancy()

}



@Composable
fun All_Vacancy()
{
    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.height(15.dp))
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp))
        { Button(onClick = {}) { Text(text="Поиск вакансий") };
            Button(onClick = {}) { Text(text="Домой") } }

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy()

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy()

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy()

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy()

        Spacer(modifier = Modifier.height(30.dp))
        Vacancy()
    }

}



@Composable
fun Vacancy(){
    Column(modifier = Modifier.fillMaxWidth().clickable(onClick = {}))
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