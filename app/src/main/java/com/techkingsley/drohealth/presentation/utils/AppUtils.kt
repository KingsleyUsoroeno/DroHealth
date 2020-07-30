package com.techkingsley.drohealth.presentation.utils

import android.app.Activity
import android.os.Build
import android.view.WindowManager
import androidx.lifecycle.MutableLiveData
import java.util.regex.Pattern

object AppUtils {

    fun validateFields(key: MutableLiveData<String>, errorLiveData: MutableLiveData<String>, field: String): Boolean {
        return if (key.value!!.trim().isEmpty()) {
            errorLiveData.value = "$field is required"
            false
        } else {
            errorLiveData.value = null
            true
        }
    }

    fun isEmailValid(email: String): Boolean {
        return if (email.isNotEmpty()) {
            val pattern = Pattern.compile(Constant.EMAIL_PATTERN)
            pattern.matcher(email.trim()).matches()
        } else {
            false
        }
    }

    fun setStatusBarColor(activity: Activity, color: Int, setUiVisibility: Boolean = false) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            val view = activity.window.decorView
            activity.window.statusBarColor = color
        }
    }
}