package com.jdlstudios.jdldevbox.di

import com.jdlstudios.jdldevbox.domain.usecases.GetCategoryUseCase
import com.jdlstudios.jdldevbox.domain.usecases.GetFrameworksUseCase
import com.jdlstudios.jdldevbox.domain.usecases.GetMetaConfigUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::GetCategoryUseCase)
    singleOf(::GetMetaConfigUseCase)
    singleOf(::GetFrameworksUseCase)
}
