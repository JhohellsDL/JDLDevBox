package com.jdlstudios.jdldevbox.data.repository

import com.jdlstudios.jdldevbox.data.datasource.MetaDataSource
import com.jdlstudios.jdldevbox.data.remote.model.MetaConfig
import com.jdlstudios.jdldevbox.domain.repository.MetaConfigRepository

class MetaConfigRepositoryImpl(
    private val metaDataSource: MetaDataSource
) : MetaConfigRepository {
    override suspend fun getMetaConfig(): MetaConfig {
        return metaDataSource.getMetaConfig()
    }
}
