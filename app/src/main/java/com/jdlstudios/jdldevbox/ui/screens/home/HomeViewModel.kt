package com.jdlstudios.jdldevbox.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdlstudios.jdldevbox.data.remote.model.CategoryResponse
import com.jdlstudios.jdldevbox.domain.usecases.GetCategoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getCategoryUseCase: GetCategoryUseCase) : ViewModel() {

    private val _categories = MutableStateFlow(CategoryResponse(emptyList()))
    val categories = _categories.asStateFlow()

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val result = getCategoryUseCase()
                _categories.value = result
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}