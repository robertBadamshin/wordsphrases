package com.wordphrases.data.repository.datasource

import com.wordphrases.ResultWrapper
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.*

class AuthDataSource {

    suspend fun sendLinkToEmail(email: String) {
        val actionCodeSettings = ActionCodeSettings(
            url = "https://wordsphrasesapp.page.link",
            androidPackageName = AndroidPackageName(
                minimumVersion = "1",
                installIfNotAvailable = true,
                packageName = "com.app.wordsphrases.debug",
            ),
            // TODO set ios package
            iOSBundleId = "com.example.ios",
            canHandleCodeInApp = true,
        )

        Firebase.auth.sendSignInLinkToEmail(
            email = email,
            actionCodeSettings = actionCodeSettings
        )
    }

    suspend fun signIn(email: String, link: String): ResultWrapper<FirebaseUser> {
        val authResult = try {
            Firebase.auth.signInWithEmailLink(email, link)
        } catch (exception: Exception) {
            return ResultWrapper.createFailure(exception)
        }

        val user = authResult.user
        return if (user != null) {
            ResultWrapper.createSuccess(user)
        } else {
            val exception = IllegalStateException("login not successful")
            ResultWrapper.createFailure(exception)
        }
    }
}