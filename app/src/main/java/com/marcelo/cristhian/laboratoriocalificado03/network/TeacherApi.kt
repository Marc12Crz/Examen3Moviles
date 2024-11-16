package com.marcelo.cristhian.laboratoriocalificado03.network

import com.marcelo.cristhian.laboratoriocalificado03.TeachersResponse
import retrofit2.http.GET
import com.marcelo.cristhian.laboratoriocalificado03.model.Teacher

interface TeacherApi {
    @GET("/list/teacher")
    suspend fun getTeachers(): TeachersResponse
}