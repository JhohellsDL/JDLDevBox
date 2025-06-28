package com.jdlstudios.jdldevbox.domain.usecases

import com.jdlstudios.jdldevbox.data.remote.model.MetaConfig
import com.jdlstudios.jdldevbox.domain.repository.MetaConfigRepository

class GetMetaConfigUseCase(private val repository: MetaConfigRepository) {
    suspend operator fun invoke(): MetaConfig {
        return repository.getMetaConfig()
    }
}
