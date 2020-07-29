package com.techkingsley.drohealth.data.local.storage

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.techkingsley.drohealth.data.local.model.User
import com.techkingsley.drohealth.presentation.utils.Constant

private const val TAG = "SharedPreferenceStorage"

class SharedPreferenceStorage(private val context: Context) : Storage {

    private val sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
    private val gsonConverter = Gson()

    override fun setUser(key: String, user: User) {
        if (key.isEmpty()) return
        with(sharedPreferences.edit()) {
            putString(key, convertUserToString(user))
            apply()
        }
    }

    override fun getCurrentUser(): User? {
        val user = sharedPreferences.getString(Constant.USER, "")
        if (user.isNullOrEmpty()) return null
        Log.i(TAG, "passed user from GsonConverter is $user")
        return gsonConverter.fromJson(user, User::class.java)
    }

    override fun convertUserToString(user: User): String {
        return gsonConverter.toJson(user)
    }
}