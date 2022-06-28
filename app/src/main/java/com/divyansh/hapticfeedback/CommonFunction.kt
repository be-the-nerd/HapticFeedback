package com.divyansh.hapticfeedback

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

fun click(context: Context){
    val sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    val isHapticFeedbackOn = sharedPreferences.getBoolean("isHapticFeedbackOn", true)
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(VIBRATOR_SERVICE) as Vibrator
    }
    if (isHapticFeedbackOn) vibrator.vibrate(VibrationEffect.createOneShot(50,150))
}

fun press(context: Context){
    val sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    val isHapticFeedbackOn = sharedPreferences.getBoolean("isHapticFeedbackOn", true)
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(VIBRATOR_SERVICE) as Vibrator
    }
    if (isHapticFeedbackOn) vibrator.vibrate(VibrationEffect.createOneShot(100,150))
}

//Common code
fun clickOrPress(context: Context, isPress: Boolean = false) {
    val sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    val isHapticFeedbackOn = sharedPreferences.getBoolean("isHapticFeedbackOn", true)
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager =
            context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(VIBRATOR_SERVICE) as Vibrator
    }
    if (isHapticFeedbackOn){
        if (isPress) vibrator.vibrate(VibrationEffect.createOneShot(100, 200))
        else vibrator.vibrate(VibrationEffect.createOneShot(50, 100))
    }
}

