package com.example.redmining.responses

data class Project(
    val author: Author,
    val created_on: String,
    val currency: String,
    val custom_fields: List<CustomField>,
    val description: String,
    val due_date: String,
    val easy_external_id: Any,
    val easy_is_easy_template: Boolean,
    val homepage: String,
    val id: Int,
    val identifier: String,
    val is_public: Boolean,
    val name: String,
    val parent: Parent,
    val scheduled_for_destroy: Boolean,
    val start_date: String,
    val status: Int,
    val sum_estimated_hours: Double,
    val sum_time_entries: Double,
    val updated_on: String
)