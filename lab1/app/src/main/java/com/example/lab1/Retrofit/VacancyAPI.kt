package com.example.lab1.Retrofit

import retrofit2.http.GET
import retrofit2.http.Query



interface VacancyAPI {
    @GET("vacancies")
    suspend fun getVacancies(
        @Query("name") query: String,
        @Query("area") area: String = "1",
        @Query("per_page") perPage: Int = 20
    ): AllVacancy
}