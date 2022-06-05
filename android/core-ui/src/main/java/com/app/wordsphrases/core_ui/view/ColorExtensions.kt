package com.app.wordsphrases.core_ui.view

import android.content.Context
import android.util.TypedValue
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat

@ColorInt
fun Int.resolveColorInt(context: Context): Int {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(this, typedValue, true)
    return ContextCompat.getColor(context, typedValue.resourceId)
}
