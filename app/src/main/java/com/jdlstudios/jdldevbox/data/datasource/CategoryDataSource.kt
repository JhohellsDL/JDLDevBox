package com.jdlstudios.jdldevbox.data.datasource

import com.jdlstudios.jdldevbox.data.remote.CategoriesApi

class CategoryDataSource(
    private val api: CategoriesApi
) {
    suspend fun getCategories() = api.getCategories()
}