package com.app.wordsphrases.email_sender_impl.domain

import android.content.Intent
import com.app.wordsphrases.email_sender_api.FeedbackEmailSender
import javax.inject.Inject

class FeedbackEmailSenderImpl @Inject constructor(
    private val createIntentForEmail: CreateIntentForEmail,
    private val getVersionName: GetVersionName,
) : FeedbackEmailSender {

    override fun invoke(): Intent {
        val intent = createIntentForEmail()

        val versionName = getVersionName()
        val subject = "Feedback. Version: $versionName"
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)

        return Intent.createChooser(intent, "Send feedback")
    }
}