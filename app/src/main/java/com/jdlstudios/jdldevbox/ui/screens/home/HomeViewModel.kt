package com.jdlstudios.jdldevbox.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdlstudios.jdldevbox.data.remote.model.CategoriesResponse
import com.jdlstudios.jdldevbox.domain.usecases.GetCategoryUseCase
import com.jdlstudios.jdldevbox.navigation.AppNavigator // Importar AppNavigator
import com.jdlstudios.jdldevbox.navigation.NavEvent // Importar NavEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCategoriesUseCase: GetCategoryUseCase,
    private val appNavigator: AppNavigator // Inyectar AppNavigator
) : ViewModel() {

    private val _categories = MutableStateFlow(CategoriesResponse())
    val categories: StateFlow<CategoriesResponse> = _categories.asStateFlow()

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val categories = getCategoriesUseCase()
                _categories.value = categories
            } catch (e: Exception) {
                // Manejar error
            }
        }
    }

    // Nueva función para manejar el clic en la categoría
    fun onCategoryClick(categoryId: String) {
        appNavigator.navigate(NavEvent.NavigateToToolsScreen)
    }
}