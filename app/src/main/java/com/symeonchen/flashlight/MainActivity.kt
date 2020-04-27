package com.symeonchen.flashlight

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.symeonchen.flashlight.FlashLightUtils.Companion.turnOffFlashLight
import com.symeonchen.flashlight.FlashLightUtils.Companion.turnOnFlashLight
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var viewModel: FlashLightViewModel? = null

    private var cameraManager: CameraManager? = null
    private var cameraId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        setDataObserver()
        setClickListener()
        initCamera()
    }

    private fun initViewModel() {
        val flashLightViewModelFactory = ViewModelInjection.provideFlashLightViewModelFactory()
        viewModel =
            ViewModelProvider(this, flashLightViewModelFactory).get(FlashLightViewModel::class.java)
    }

    private fun initCamera() {
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager?.cameraIdList?.get(0)
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    private fun setDataObserver() {
        viewModel?.flashLightState?.observe(this, Observer {
            if (it) {
                iv_flashlight.setImageResource(R.drawable.ic_flashlight_on)
            } else {
                iv_flashlight.setImageResource(R.drawable.ic_flashlight_off)
            }

        })
    }

    private fun setClickListener() {
        iv_flashlight.setOnClickListener {
            val flashLightState = viewModel?.flashLightState?.value == true
            if (flashLightState && turnOffFlashLight(cameraManager, cameraId)) {
                viewModel?.flashLightState?.postValue(false)
            }
            if (!flashLightState && turnOnFlashLight(cameraManager, cameraId))
                viewModel?.flashLightState?.postValue(true)
        }
    }


    override fun onStop() {
        super.onStop()
        if (viewModel?.flashLightState?.value == true) {
            turnOffFlashLight(cameraManager, cameraId)
        }
    }
}
