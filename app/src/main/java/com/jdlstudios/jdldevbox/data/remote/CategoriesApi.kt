package com.jdlstudios.jdldevbox.data.remote

import com.jdlstudios.jdldevbox.data.remote.model.CategoriesResponse
import retrofit2.http.GET

interface CategoriesApi {
    @GET("categories.json")
    suspend fun getCategories(): CategoriesResponse
}