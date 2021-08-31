package com.app.wordsphrases.core_ui.view

import android.content.res.Resources
import kotlin.math.roundToInt

fun Int.dpToPx(): Int = (this * Resources.getSystem().displayMetrics.density).roundToInt()

fun Int.dpToFloatPx(): Float = this * Resources.getSystem().displayMetrics.density