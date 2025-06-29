package com.jdlstudios.jdldevbox.domain.usecases

import com.jdlstudios.jdldevbox.data.remote.model.CategoriesResponse
import com.jdlstudios.jdldevbox.domain.repository.CategoryRepository

class GetCategoryUseCase(private val repository: CategoryRepository) {
    suspend operator fun invoke(): CategoriesResponse {
        return repository.getCategories()
    }
}