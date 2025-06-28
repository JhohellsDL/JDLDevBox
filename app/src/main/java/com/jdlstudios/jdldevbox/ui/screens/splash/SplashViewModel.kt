package com.jdlstudios.jdldevbox.ui.screens.splash

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
        fetchMetaConfig()
    }

    private fun fetchMetaConfig() {
        viewModelScope.launch {
            try {
                val meta = getMetaUseCase()
                _meta.value = meta
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                // Wait for an additional second after loading is complete
                delay(1000)
                appNavigator.navigate(NavEvent.NavigateToHome)
            }
        }
    }
}