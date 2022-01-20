package com.example.redmining.responses

data class User(
    val admin: Boolean,
    val api_key: String,
    val created_on: String,
    val custom_fields: List<CustomFieldX>,
    val firstname: String,
    val id: Int,
    val last_login_on: String,
    val lastname: String,
    val login: String,
    val mail: String
)