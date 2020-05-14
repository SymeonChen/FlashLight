package com.symeonchen.flashlight


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FlashLightViewModel : ViewModel() {
    var flashLightState: MutableLiveData<Boolean> = MutableLiveData()
    var flashLightAutoClose: ScLiveData<Boolean> = ScLiveData()

    init {
        flashLightState.value = false

        flashLightAutoClose.setValue(DataInjection.autoClose)
        flashLightAutoClose.listener = object : ScLiveData.OnLiveDataValueInput<Boolean> {
            override fun onValueInput(value: Boolean) {
                DataInjection.autoClose = value
            }
        }
    }


}