package com.jdlstudios.jdldevbox.domain.repository

import com.jdlstudios.jdldevbox.data.remote.model.CategoryResponse

interface CategoryRepository {
    suspend fun getCategories(): CategoryResponse
}
