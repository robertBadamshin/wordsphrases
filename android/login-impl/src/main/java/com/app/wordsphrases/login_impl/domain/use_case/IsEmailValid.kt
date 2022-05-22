package com.app.wordsphrases.login_impl.domain.use_case

import android.util.Patterns
import javax.inject.Inject

class IsEmailValid @Inject constructor() {

    operator fun invoke(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}