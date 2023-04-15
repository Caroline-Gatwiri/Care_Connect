package com.example.careconnect.data


import com.google.gson.annotations.SerializedName

data class ChildDetails(
    @SerializedName("child")
    val child: List<Child>
)