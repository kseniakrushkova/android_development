package com.example.orientation

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getScreenOrientation()
//        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }

    private var mOrientation = ""
    private val mButton: Button? = null

    val ORIENTATION_PORTRAIT = "Портретный режим"
    val ORIENTATION_LANDSCAPE = "Альбомный режим"

    var mState = false

    private fun isLandscapeMode(activity: Activity): Boolean {
        val width = activity.windowManager.defaultDisplay.width
        val height = activity.windowManager.defaultDisplay.height
        val isLandscape = width > height
        mOrientation = if (isLandscape) "Альбомная" else "Портретная"
        return isLandscape
    }

    private fun getScreenOrientation(): String {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> "Портретная ориентация"
            Configuration.ORIENTATION_LANDSCAPE -> "Альбомная ориентация"
            else -> ""
        }
    }

    private fun getRotateOrientation(): String {
        return when (windowManager.defaultDisplay.rotation) {
            Surface.ROTATION_0 -> "Не поворачивали"
            Surface.ROTATION_90 -> "Повернули на 90 градусов по часовой стрелке"
            Surface.ROTATION_180 -> "Повернули на 180 градусов"
            Surface.ROTATION_270 -> "Повернули на 90 градусов против часовой стрелки"
            else -> "Не понятно"
        }
    }

    fun onClick(view: View?) {
        // state FALSE: переключаемся на LANDSCAPE
        if (!mState) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            mButton!!.text = ORIENTATION_PORTRAIT
        } else {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            mButton!!.text = ORIENTATION_LANDSCAPE
        }
        // обновляем state на противоположное значение
        mState = !mState
    }}