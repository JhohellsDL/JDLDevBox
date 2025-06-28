package com.jdlstudios.jdldevbox.data.remote.model

data class MetaConfig(
    val version: String = "",
    val lastUpdated: String = "",
    val totalTools: Int = 0,
    val repository: Repository = Repository(),
    val api: Api = Api(),
    val stats: Stats = Stats(),
    val settings: Settings = Settings()
) {
    data class Repository(
        val name: String = "",
        val description: String = "",
        val author: String = "",
        val license: String = ""
    )

    data class Api(
        val baseUrl: String = "",
        val endpoints: Endpoints = Endpoints()
    ) {
        data class Endpoints(
            val categories: String = "",
            val meta: String = "",
            val allTools: String = "",
            val frameworks: String = "",
            val libraries: String = "",
            val tools: String = "",
            val documentation: String = "",
            val design: String = "",
            val testing: String = "",
            val devops: String = "",
            val learning: String = ""
        )
    }

    data class Stats(
        val totalTools: Int = 0,
        val categoriesCount: Int = 0,
        val tagsCount: Int = 0,
        val lastSync: String = ""
    )

    data class Settings(
        val autoSync: Boolean = false,
        val syncInterval: Int = 0,
        val cacheExpiry: Int = 0,
        val maxRetries: Int = 0
    )
}
