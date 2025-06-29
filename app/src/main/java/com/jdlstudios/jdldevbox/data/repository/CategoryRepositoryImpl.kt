package com.jdlstudios.jdldevbox.data.repository

import com.jdlstudios.jdldevbox.data.datasource.CategoryDataSource
import com.jdlstudios.jdldevbox.data.remote.model.CategoriesResponse
import com.jdlstudios.jdldevbox.data.remote.model.FrameworksResponse
import com.jdlstudios.jdldevbox.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryDataSource: CategoryDataSource
) : CategoryRepository {
    override suspend fun getCategories(): CategoriesResponse {
        return categoryDataSource.getCategories()
    }

    override suspend fun getFrameworks(): FrameworksResponse {
        return categoryDataSource.getFrameworks()
    }
}
