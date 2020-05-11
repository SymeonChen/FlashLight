package com.symeonchen.flashlight


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FlashLightViewModel : ViewModel() {
    var flashLightState: MutableLiveData<Boolean> = MutableLiveData()
    var flashLightAutoClose: MutableLiveData<Boolean> = MutableLiveData()

    init {
        flashLightState.value = false
        flashLightAutoClose.value = DataInjection.autoClose
    }


}