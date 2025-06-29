package com.jdlstudios.jdldevbox.domain.repository

import com.jdlstudios.jdldevbox.data.remote.model.CategoriesResponse
import com.jdlstudios.jdldevbox.data.remote.model.FrameworksResponse

interface CategoryRepository {
    suspend fun getCategories(): CategoriesResponse
    suspend fun getFrameworks(): FrameworksResponse
}
