package com.symeonchen.flashlight

import android.hardware.camera2.CameraManager

class FlashLightUtils {

    companion object {
        fun turnOnFlashLight(cameraManager: CameraManager?, cameraId: String?): Boolean {
            try {
                cameraManager ?: return false
                cameraId ?: return false
                cameraManager.setTorchMode(cameraId, true)
                return true
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }

        fun turnOffFlashLight(cameraManager: CameraManager?, cameraId: String?): Boolean {
            try {
                cameraManager ?: return false
                cameraId ?: return false
                cameraManager.setTorchMode(cameraId, false)
                return true
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }
    }
}