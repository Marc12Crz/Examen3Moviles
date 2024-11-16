package com.marcelo.cristhian.laboratoriocalificado03.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://private-effe28-tecsup1.apiary-mock.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: TeacherApi = retrofit.create(TeacherApi::class.java)
}