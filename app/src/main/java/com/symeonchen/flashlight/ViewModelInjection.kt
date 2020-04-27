package com.symeonchen.flashlight

object ViewModelInjection {

    fun provideFlashLightViewModelFactory(): FlashLightViewModelFactory {
        return FlashLightViewModelFactory()
    }


}