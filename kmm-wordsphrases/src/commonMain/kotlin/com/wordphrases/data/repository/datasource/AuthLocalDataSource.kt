package com.wordphrases.data.repository.datasource

expect class AuthLocalDataSource constructor() {

    fun saveEmail(email: String)

    fun getEmail(): String?

    fun clearEmail()
}