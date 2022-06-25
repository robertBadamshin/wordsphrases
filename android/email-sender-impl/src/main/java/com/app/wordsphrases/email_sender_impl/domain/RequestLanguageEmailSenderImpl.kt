package com.app.wordsphrases.email_sender_impl.domain

import android.content.Intent
import com.app.wordsphrases.email_sender_api.RequestLanguageEmailSender
import javax.inject.Inject

class RequestLanguageEmailSenderImpl @Inject constructor(
    private val createIntentForEmail: CreateIntentForEmail,
    private val getVersionName: GetVersionName,
) : RequestLanguageEmailSender {

    override fun invoke(): Intent {
        val intent = createIntentForEmail()

        val versionName = getVersionName()
        val subject = "Feedback. Version: $versionName. Request language"
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)

        return Intent.createChooser(intent, "Request language")
    }
}