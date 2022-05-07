package com.app.wordsphrases.email_sender_impl.domain

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.app.wordsphrases.email_sender_api.FeedbackEmailSender
import javax.inject.Inject

class FeedbackEmailSenderImpl @Inject constructor(
    private val context: Context,
) : FeedbackEmailSender {

    override fun invoke(): Intent {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("wordsphrasesapp@gmail.com"))

        val versionName = getVersionName()
        val subject = "Feedback. Version: $versionName"
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)

        return Intent.createChooser(intent, "Send feedback")
    }

    private fun getVersionName(): String {
        return try {
            context
                .packageManager
                .getPackageInfo(context.packageName, PackageManager.GET_META_DATA)
                .versionName
        } catch (throwable: Throwable) {
            ""
        }
    }
}