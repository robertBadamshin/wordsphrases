package com.app.wordsphrases.email_sender_api

import android.content.Intent

interface FeedbackEmailSender {

    // returns intent to avoid providing activity context
    operator fun invoke(): Intent
}