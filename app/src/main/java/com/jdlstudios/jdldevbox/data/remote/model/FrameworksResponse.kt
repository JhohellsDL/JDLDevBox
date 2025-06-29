package com.jdlstudios.jdldevbox.data.remote.model

data class FrameworksResponse(
    val version: String = "1.0",
    val category : String = "Frameworks",
    val lastUpdated: String = "2023-10-01",
    val tools: List<ToolResponse> = emptyList()
)
