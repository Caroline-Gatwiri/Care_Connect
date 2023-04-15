package com.example.careconnect.data

import retrofit2.http.GET

interface ApiService {
    @GET("api/child/test/")
    suspend fun getAllChildren(): ChildDetails
}