package com.example.lab1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab1.screens.About_me
import com.example.lab1.screens.All_Vacancy
import com.example.lab1.screens.Auth_Prev
import com.example.lab1.screens.MainScreen
import com.example.lab1.screens.Recovery_Password
import com.example.lab1.screens.SearchSettings
import com.example.lab1.screens.vacancy


@Composable
fun navigation(nav_controller: NavHostController)
{
    NavHost(
        navController = nav_controller,
        startDestination = "To_Auth_prev") {

        composable("To_home"){ MainScreen(nav_controller) }

        composable("To_Recovery_password"){ Recovery_Password(nav_controller) }
        composable("To_SearchSettings"){ SearchSettings(nav_controller) }
        composable("To_vacancy"){ vacancy(nav_controller) }

        composable("To_Auth_prev"){ Auth_Prev(nav_controller) }
        composable("To_All_Vacancy"){ All_Vacancy(nav_controller) }
        composable("To_About_me"){ About_me(nav_controller) }

    }
}