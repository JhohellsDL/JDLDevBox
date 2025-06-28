package com.jdlstudios.jdldevbox.di

import com.jdlstudios.jdldevbox.data.repository.CategoryRepositoryImpl
import com.jdlstudios.jdldevbox.data.repository.MetaConfigRepositoryImpl
import com.jdlstudios.jdldevbox.domain.repository.CategoryRepository
import com.jdlstudios.jdldevbox.domain.repository.MetaConfigRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CategoryRepository> {
        CategoryRepositoryImpl(get())
    }
    single<MetaConfigRepository> {
        MetaConfigRepositoryImpl(get())
    }
}