package com.example.mylife.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mylife.ui.welcome.WelcomeDestination

class navViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    var start by mutableStateOf(WelcomeDestination.route)
}