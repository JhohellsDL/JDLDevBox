package com.jdlstudios.jdldevbox.navigation

sealed class NavEvent {
    object NavigateToHome : NavEvent()
    object NavigateToMetaScreen : NavEvent()
    object NavigateToCategoriesScreen : NavEvent()
    data class NavigateToCategoryDetailScreen(val categoryId: String) : NavEvent()
    object NavigateToSettingsScreen : NavEvent()
    object NavigateToAboutScreen : NavEvent()
    object NavigateToFeedbackScreen : NavEvent()
    object NavigateToPrivacyPolicyScreen : NavEvent()
    object NavigateToTermsOfServiceScreen : NavEvent()
}
