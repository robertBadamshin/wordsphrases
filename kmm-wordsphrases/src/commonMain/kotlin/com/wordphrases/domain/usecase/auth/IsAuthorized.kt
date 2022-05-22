package com.wordphrases.domain.usecase.auth

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth

class IsAuthorized {

    operator fun invoke(): Boolean {
        return Firebase.auth.currentUser != null
    }
}