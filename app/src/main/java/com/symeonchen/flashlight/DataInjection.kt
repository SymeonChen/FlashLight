package com.symeonchen.flashlight

import com.tencent.mmkv.MMKV


/**
 * Created by SymeonChen on 2020/5/11.
 */
object DataInjection {
    var autoClose: Boolean
        get() {
            return MMKV.defaultMMKV()
                .getBoolean(ScConstant.AUTO_CLOSE, ScConstant.DEFAULT_AUTO_CLOSE)
        }
        set(value) {
            MMKV.defaultMMKV().putBoolean(ScConstant.AUTO_CLOSE, value)
        }
}