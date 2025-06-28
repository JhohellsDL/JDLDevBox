package com.jdlstudios.jdldevbox.data.repository

import com.jdlstudios.jdldevbox.data.datasource.CategoryDataSource
import com.jdlstudios.jdldevbox.domain.repository.CategoryRepository
import com.jdlstudios.jdldevbox.data.remote.model.CategoryResponse

class CategoryRepositoryImpl(
    private val categoryDataSource: CategoryDataSource
) : CategoryRepository {
    override suspend fun getCategories(): CategoryResponse {
        return categoryDataSource.getCategories()
    }
}
