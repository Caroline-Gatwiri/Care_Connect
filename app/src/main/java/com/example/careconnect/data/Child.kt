package com.example.careconnect.data


import com.google.gson.annotations.SerializedName

data class Child(
    @SerializedName("age")
    val age: String,
    @SerializedName("child_name")
    val childName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("guardian_name")
    val guardianName: String,
    @SerializedName("guardian_phone")
    val guardianPhone: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String
)