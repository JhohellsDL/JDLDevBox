package com.jdlstudios.jdldevbox.data.datasource

import com.jdlstudios.jdldevbox.data.remote.MetaConfigService

class MetaDataSource(
    private val api: MetaConfigService
) {
    suspend fun getMetaConfig() = api.getMetaConfig()
}