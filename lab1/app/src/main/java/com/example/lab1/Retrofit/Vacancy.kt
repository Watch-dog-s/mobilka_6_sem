package com.example.lab1.Retrofit


data class AllVacancy(val items: List<Vacancy>)

data class Vacancy(
    val name: String,
    val description: String? = null
)
