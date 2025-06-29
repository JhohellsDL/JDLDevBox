package com.jdlstudios.jdldevbox.domain.usecases

import com.jdlstudios.jdldevbox.data.remote.model.FrameworksResponse
import com.jdlstudios.jdldevbox.domain.repository.CategoryRepository

class GetFrameworksUseCase(private val repository: CategoryRepository) {
    suspend operator fun invoke(): FrameworksResponse {
        return repository.getFrameworks()
    }
}