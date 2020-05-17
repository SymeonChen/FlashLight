package com.symeonchen.flashlight

import androidx.lifecycle.LiveData

/**
 * Created by SymeonChen on 2019-10-27.
 */
class ScLiveData<T> : LiveData<T>() {

    var listener: OnLiveDataValueInput<T>? = null

    public override fun setValue(value: T) {
        super.setValue(value)
        listener?.onValueInput(value)
    }


    public override fun postValue(value: T) {
        super.postValue(value)
        listener?.onValueInput(value)
    }

    interface OnLiveDataValueInput<T> {
        fun onValueInput(value: T)
    }
}