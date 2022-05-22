package com.wordphrases.domain.usecase.auth

import com.wordphrases.ResultWrapper
import com.wordphrases.data.repository.AuthRepository
import com.wordphrases.di.RepositoryProvider
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth

class AuthenticateUser(
    private val authRepository: AuthRepository = RepositoryProvider.authRepository,
) {

    suspend operator fun invoke(emailLink: String): ResultWrapper<Unit> {
        if (Firebase.auth.isSignInWithEmailLink(emailLink)) {
            val email = authRepository.getEmail()
            if (email == null) {
                val exception = IllegalStateException("email is null")
                return ResultWrapper.createFailure(exception)
            }

            val authResult = authRepository.signIn(email, emailLink)

            return if (authResult.isSuccess) {
                authRepository.clearEmail()
                ResultWrapper.createSuccess(Unit)
            } else {
                ResultWrapper.createFailure(authResult.requireException())
            }
        } else {
            val exception = IllegalArgumentException("wrong link")
            return ResultWrapper.createFailure(exception)
        }
    }
}