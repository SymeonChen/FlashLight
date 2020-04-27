package com.symeonchen.flashlight

import android.hardware.camera2.CameraManager
import android.os.Build

class FlashLightUtils {

    companion object {
        fun turnOnFlashLight(cameraManager: CameraManager?, cameraId: String?): Boolean {
            try {
                cameraManager ?: return false
                cameraId ?: return false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cameraManager.setTorchMode(cameraId, true)
                    return true
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }

        fun turnOffFlashLight(cameraManager: CameraManager?, cameraId: String?): Boolean {
            try {
                cameraManager ?: return false
                cameraId ?: return false
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cameraManager.setTorchMode(cameraId, false)
                    return true
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }
    }
}