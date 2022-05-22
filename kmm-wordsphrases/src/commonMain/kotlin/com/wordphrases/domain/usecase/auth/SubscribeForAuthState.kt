package com.wordphrases.domain.usecase.auth

import com.wordphrases.data.repository.AuthRepository
import com.wordphrases.di.RepositoryProvider
import com.wordphrases.domain.entity.AuthState
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.flow.*

class SubscribeForAuthState(
    private val authRepository: AuthRepository = RepositoryProvider.authRepository,
) {

    operator fun invoke(): Flow<AuthState> {
        return Firebase.auth
            .idTokenChanged
            .onEach { firebaseUser ->
                if (firebaseUser != null) {
                    authRepository.setUserId(firebaseUser.uid)
                }
            }
            .map { firebaseUser ->
                if (firebaseUser != null) {
                    AuthState.Authenticated
                } else {
                    AuthState.NotAuthenticated
                }
            }
    }
}