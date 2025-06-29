package com.jdlstudios.jdldevbox.data.remote

import com.jdlstudios.jdldevbox.data.remote.model.FrameworksResponse
import retrofit2.http.GET

interface CategoryApi {
    @GET("tools/frameworks.json")
    suspend fun getFrameworks(): FrameworksResponse
}