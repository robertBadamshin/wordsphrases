package com.wordphrases.data.repository

import com.wordphrases.ResultWrapper
import com.wordphrases.data.repository.datasource.*
import com.wordphrases.di.DataSourceProvider
import dev.gitlive.firebase.auth.FirebaseUser

class AuthRepository(
    private val authDataSource: AuthDataSource = DataSourceProvider.authDataSource,
    private val authLocalDataSource: AuthLocalDataSource = DataSourceProvider.authLocalDataSource,
) {

    private var userId: String? = null

    fun setUserId(userId: String) {
        this.userId = userId
    }

    fun requireUserId(): String {
        return userId ?: throw IllegalStateException("userId is null")
    }

    suspend fun sendLinkToEmail(email: String) {
        authDataSource.sendLinkToEmail(email)
    }

    fun saveEmail(email: String) {
        authLocalDataSource.saveEmail(email)
    }

    fun clearEmail() {
        authLocalDataSource.clearEmail()
    }

    fun getEmail(): String? {
        return authLocalDataSource.getEmail()
    }

    suspend fun signIn(email: String, link: String): ResultWrapper<FirebaseUser> {
        return authDataSource.signIn(email, link)
    }
}