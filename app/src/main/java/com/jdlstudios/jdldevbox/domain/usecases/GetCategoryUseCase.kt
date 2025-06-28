package com.jdlstudios.jdldevbox.domain.usecases

import com.jdlstudios.jdldevbox.data.remote.model.CategoryResponse
import com.jdlstudios.jdldevbox.domain.repository.CategoryRepository

class GetCategoryUseCase(private val repository: CategoryRepository) {
    suspend operator fun invoke(): CategoryResponse {
        return repository.getCategories()
    }
}