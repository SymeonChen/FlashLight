package com.symeonchen.flashlight


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FlashLightViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = FlashLightViewModel() as T

}