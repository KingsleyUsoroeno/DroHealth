package com.techkingsley.drohealth.presentation.ui.authentication.sign_up

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.techkingsley.drohealth.data.local.model.User
import com.techkingsley.drohealth.data.local.storage.Storage
import com.techkingsley.drohealth.presentation.utils.SingleEventLiveData
import com.techkingsley.drohealth.presentation.utils.AppUtils
import com.techkingsley.drohealth.presentation.utils.Constant

class SignUpViewModel internal constructor(val app: Application, private val storage: Storage) : AndroidViewModel(app) {

    companion object {
        private const val TAG = "SignUpViewModel"
    }

    //observable fields with DataBinding
    val firstNameLiveData = MutableLiveData("")
    val lastNameLiveData = MutableLiveData("")
    val emailLiveData = MutableLiveData("")
    val passwordLiveData = MutableLiveData("")

    var errorFirstNameLiveData = MutableLiveData("")
    var errorLastNameLiveData = MutableLiveData("")
    var errorEmailLiveData = MutableLiveData("")
    var errorPasswordLiveData = MutableLiveData("")

    private val _loginState = SingleEventLiveData<Boolean>()

    val loginState: SingleEventLiveData<Boolean>
        get() = _loginState

    fun registerUser() {
        if (!AppUtils.validateFields(firstNameLiveData, errorFirstNameLiveData, "First Name")
            || !AppUtils.validateFields(lastNameLiveData, errorLastNameLiveData, "Last Name") ||
            !AppUtils.validateFields(emailLiveData, errorEmailLiveData, "Email Address") || !AppUtils.validateFields(passwordLiveData, errorPasswordLiveData, "Password")
        ) {
            return
        }

        if (!AppUtils.isEmailValid(emailLiveData.value!!)) {
            errorEmailLiveData.value = "Email is not valid"
            return
        }

        val firstName = firstNameLiveData.value.toString().trim()
        val lastName = lastNameLiveData.value.toString().trim()
        val email = emailLiveData.value.toString().trim()
        val password = passwordLiveData.value.toString().trim()

        Log.i(TAG, "registering first name is $firstName and lastName $lastName and email $email and password $password")

        val user = User(firstName, lastName, email, password)
        storage.setUser(Constant.USER, user)
        _loginState.value = true
    }
}