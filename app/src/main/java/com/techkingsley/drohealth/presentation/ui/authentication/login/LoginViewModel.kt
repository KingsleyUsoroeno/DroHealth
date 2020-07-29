package com.techkingsley.drohealth.presentation.ui.authentication.login

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.techkingsley.drohealth.data.local.storage.Storage
import com.techkingsley.drohealth.presentation.utils.AppUtils.isEmailValid
import com.techkingsley.drohealth.presentation.utils.AppUtils.validateFields

class LoginViewModel internal constructor(val app: Application, private val storage: Storage) : AndroidViewModel(app) {

    companion object {
        private const val TAG = "LoginViewModel"
    }

    //observable fields with DataBinding
    val emailLiveData = MutableLiveData("")
    val passwordLiveData = MutableLiveData("")

    var errorEmailLiveData = MutableLiveData("")
    var errorPasswordLiveData = MutableLiveData("")

    private val _loginState = MutableLiveData<Boolean>(false)

    val loginState: LiveData<Boolean>
        get() = _loginState

    fun loginUser() {
        if (!validateFields(emailLiveData, errorEmailLiveData, "Email Address") || !validateFields(passwordLiveData, errorPasswordLiveData, "Password")) {
            return
        }

        if (!isEmailValid(emailLiveData.value!!)) {
            errorEmailLiveData.value = "Email is not valid"
            return
        }

        val email = emailLiveData.value.toString().trim()
        val password = passwordLiveData.value.toString().trim()

        Log.i(TAG, "login email is $email and login password is $password")

        val user = storage.getCurrentUser()
        user?.let {
            if (email == it.email && password == it.password) {
                Toast.makeText(app.applicationContext, "Welcome back ${it.firstName} ${it.lastName}", Toast.LENGTH_LONG).show()
                _loginState.value = true
            } else {
                Toast.makeText(app.applicationContext, "Sorry user does not exist", Toast.LENGTH_LONG).show()
            }
        }
    }
}