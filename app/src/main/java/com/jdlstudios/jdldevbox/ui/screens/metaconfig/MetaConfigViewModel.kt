package com.jdlstudios.jdldevbox.ui.screens.metaconfig

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdlstudios.jdldevbox.data.remote.model.CategoryResponse
import com.jdlstudios.jdldevbox.data.remote.model.MetaConfig
import com.jdlstudios.jdldevbox.domain.usecases.GetMetaConfigUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MetaConfigViewModel(private val getMetaUseCase: GetMetaConfigUseCase): ViewModel() {

    private val _categories = MutableStateFlow<CategoryResponse>(CategoryResponse(emptyList()))
    val categories: StateFlow<CategoryResponse> get() = _categories.asStateFlow()

    private val _meta = MutableStateFlow<MetaConfig>(MetaConfig())
    val meta: StateFlow<MetaConfig> get() = _meta.asStateFlow()

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val meta = getMetaUseCase()
                _meta.value = meta
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}