package com.wordphrases.data.repository.datasource

import com.wordphrases.data.AuthPreferences

actual class AuthLocalDataSource {

    // TODO make normal constructor
    private val authPreferences: AuthPreferences = AuthPreferences()

    actual fun saveEmail(email: String) {
        authPreferences.saveEmail(email)
    }

    actual fun getEmail(): String? {
        return authPreferences.getEmail()
    }

    actual fun clearEmail() {
        authPreferences.clearEmail()
    }
}