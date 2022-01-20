package com.example.redmining.responses

data class ProjectsResponse(
    val limit: Int,
    val offset: Int,
    val projects: List<Project>,
    val total_count: Int
)