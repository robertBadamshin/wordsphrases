package com.app.wordsphrases.email_sender_impl.domain

import android.content.Context
import android.content.pm.PackageManager
import javax.inject.Inject

class GetVersionName @Inject constructor(
    private val context: Context,
) {

    operator fun invoke(): String {
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