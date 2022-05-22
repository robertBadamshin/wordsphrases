package com.wordphrases.domain.usecase.auth

import com.wordphrases.ResultWrapper
import com.wordphrases.data.repository.AuthRepository
import com.wordphrases.di.RepositoryProvider
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.*

class SendLoginLinkToEmail(
    private val authRepository: AuthRepository = RepositoryProvider.authRepository,
) {

    suspend operator fun invoke(email: String): ResultWrapper<Unit> {
        return try {
            authRepository.sendLinkToEmail(email)
            authRepository.saveEmail(email)

            ResultWrapper.createSuccess(Unit)
        } catch (exception: Exception) {
            ResultWrapper.createFailure(exception)
        }
    }
}