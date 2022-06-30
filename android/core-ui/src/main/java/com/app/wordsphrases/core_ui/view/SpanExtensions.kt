package com.app.wordsphrases.core_ui.view

import android.text.Spannable
import androidx.core.text.set

fun Spannable.setFullLengthSpan(span: Any) {
    set(0, length, span)
}