package com.symeonchen.flashlight

import android.app.Application
import com.tencent.mmkv.MMKV

/**
 * Created by SymeonChen on 2019-10-27.
 */
@Suppress("unused")
class ScApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
    }
}
