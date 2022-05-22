package com.wordphrases.data

import android.content.*

private const val emailKey = "emailKey"

class AuthPreferences {

    fun saveEmail(email: String) {
        preferences.edit().putString(emailKey, email).apply()
    }

    fun getEmail(): String? {
        return preferences.getString(emailKey, null)
    }

    fun clearEmail() {
        preferences.edit().remove(emailKey).apply()
    }

    companion object {

        // TODO create normal work with prefs for android and IoS
        lateinit var preferences: SharedPreferences

        fun init(context: Context) {
            preferences = context.getSharedPreferences(
                "auth_preferences",
                Context.MODE_PRIVATE,
            )
        }
    }
}