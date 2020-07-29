package com.techkingsley.drohealth.data.local.storage

import com.techkingsley.drohealth.data.local.model.User

interface Storage {
    fun setUser(key: String, user: User)
    fun getCurrentUser(): User?
    fun convertUserToString(user: User) : String
}