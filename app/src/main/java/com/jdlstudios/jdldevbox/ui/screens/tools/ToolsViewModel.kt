package com.jdlstudios.jdldevbox.ui.screens.tools

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdlstudios.jdldevbox.data.remote.model.FrameworksResponse
import com.jdlstudios.jdldevbox.domain.usecases.GetFrameworksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ToolsViewModel(
    private val getFrameworksUseCase: GetFrameworksUseCase
): ViewModel() {

    private val _frameworks = MutableStateFlow(FrameworksResponse())
    val frameworks: StateFlow<FrameworksResponse> get() = _frameworks.asStateFlow()

    init {
        fetchFrameworks()
    }

    private fun fetchFrameworks() {
        viewModelScope.launch {
            try {
                val response = getFrameworksUseCase()
                println("ToolsViewModel: fetchFrameworks completed successfully. Response: $response")
                _frameworks.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}