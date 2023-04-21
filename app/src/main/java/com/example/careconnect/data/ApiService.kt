package com.example.careconnect.data

import retrofit2.http.GET

interface ApiService {
    @GET("api/children")
    suspend fun getAllChildren(): ChildDetails
}