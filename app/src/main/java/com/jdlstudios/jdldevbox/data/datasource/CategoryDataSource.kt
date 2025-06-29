package com.jdlstudios.jdldevbox.data.datasource

import com.jdlstudios.jdldevbox.data.remote.CategoriesApi
import com.jdlstudios.jdldevbox.data.remote.CategoryApi

class CategoryDataSource(
    private val api: CategoriesApi,
    private val frameworksApi: CategoryApi
) {
    suspend fun getCategories() = api.getCategories()
    suspend fun getFrameworks() = frameworksApi.getFrameworks()
}