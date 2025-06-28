package com.jdlstudios.jdldevbox.domain.repository

import com.jdlstudios.jdldevbox.data.remote.model.MetaConfig

interface MetaConfigRepository {
    suspend fun getMetaConfig(): MetaConfig
}
