package com.jdlstudios.jdldevbox.di

import com.jdlstudios.jdldevbox.data.remote.CategoriesApi
import com.jdlstudios.jdldevbox.data.remote.CategoryApi
import com.jdlstudios.jdldevbox.data.remote.MetaConfigService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://raw.githubusercontent.com/JhohellsDL/dev-tools-database/main/"

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(MetaConfigService::class.java)
    }
    single {
        get<Retrofit>().create(CategoriesApi::class.java)
    }
    single{
        get<Retrofit>().create(CategoryApi::class.java)
    }
}