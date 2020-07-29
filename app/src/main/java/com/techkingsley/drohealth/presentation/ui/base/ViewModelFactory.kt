package com.techkingsley.drohealth.presentation.ui.base

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techkingsley.drohealth.data.local.storage.Storage
import com.techkingsley.drohealth.presentation.ui.authentication.login.LoginViewModel
import com.techkingsley.drohealth.presentation.ui.authentication.sign_up.SignUpViewModel

class ViewModelFactory(private val app: Application, private val storage: Storage) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(app, storage) as T
        } else if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(app, storage) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}