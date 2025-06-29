package com.jdlstudios.jdldevbox.data.remote.model

data class ToolResponse(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val url: String = "",
    val officialUrl: String = "",
    val documentationUrl: String = "",
    val githubUrl: String = "",
    val tags: List<String> = emptyList(),
    val category: String = "",
    val subcategory: String = "",
    val language: String = "",
    val rating: Double = 0.0,
    val popularity: String = "",
    val learningCurve: String = "",
    val dateAdded: String = "",
    val lastUpdated: String = "",
    val recommendedBy: String = "",
    val notes: String = "",
    val useCases: List<String> = emptyList(),
    val alternatives: List<String> = emptyList(),
    val isActive: Boolean = false,
    val license: String = "",
    val company: String = "",
    val icon: String = ""
)
