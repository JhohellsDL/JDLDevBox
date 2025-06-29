package com.jdlstudios.jdldevbox.di

import com.jdlstudios.jdldevbox.data.datasource.CategoryDataSource
import com.jdlstudios.jdldevbox.data.datasource.MetaDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        CategoryDataSource(get(), get())
    }
    single {
        MetaDataSource(get())
    }
}
