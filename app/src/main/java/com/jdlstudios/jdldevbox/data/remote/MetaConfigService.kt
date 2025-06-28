package com.jdlstudios.jdldevbox.data.remote

import com.jdlstudios.jdldevbox.data.remote.model.MetaConfig
import retrofit2.http.GET

interface MetaConfigService {
    @GET("meta.json")
    suspend fun getMetaConfig(): MetaConfig
}
