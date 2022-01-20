package com.example.redmining.responses

data class CustomField(
    val field_format: String,
    val id: Int,
    val internal_name: Any,
    val name: String,
    val value: String
)