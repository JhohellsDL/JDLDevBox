package com.jdlstudios.jdldevbox.ui.screens.splash

import android.util.Log // Importar Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdlstudios.jdldevbox.data.remote.model.MetaConfig
import com.jdlstudios.jdldevbox.domain.usecases.GetMetaConfigUseCase
import com.jdlstudios.jdldevbox.navigation.AppNavigator
import com.jdlstudios.jdldevbox.navigation.NavEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val getMetaUseCase: GetMetaConfigUseCase,
    private val appNavigator: AppNavigator
) : ViewModel() {

    private val _meta = MutableStateFlow<MetaConfig>(MetaConfig())
    val meta: StateFlow<MetaConfig> get() = _meta.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        Log.d("SplashViewModel", "SplashViewModel initialized. isLoading: ${_isLoading.value}")
        fetchMetaConfig()
    }

    private fun fetchMetaConfig() {
        viewModelScope.launch {
            Log.d("SplashViewModel", "fetchMetaConfig started.")
            try {
                val meta = getMetaUseCase()
                _meta.value = meta
                Log.d("SplashViewModel", "getMetaUseCase completed successfully. Meta: $meta")
            } catch (e: Exception) {
                Log.e("SplashViewModel", "Error fetching meta config: ${e.message}", e)
            } finally {
                Log.d("SplashViewModel", "finally block entered.")
                _isLoading.value = false // Aseguramos que el estado de carga se actualice
                Log.d("SplashViewModel", "isLoading set to false. Waiting 1 second...")
                delay(1000)
                Log.d("SplashViewModel", "Delay finished. Navigating to Home.")
                appNavigator.navigate(NavEvent.NavigateToHome)
                Log.d("SplashViewModel", "Navigation event to Home emitted.")
            }
        }
    }
}