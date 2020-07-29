package com.techkingsley.drohealth.presentation.utils

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
}