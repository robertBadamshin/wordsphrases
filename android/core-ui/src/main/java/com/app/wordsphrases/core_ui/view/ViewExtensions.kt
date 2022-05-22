package com.app.wordsphrases.core_ui.view

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


fun View.showKeyboard() {
    val inputMethodManager = context.getSystemService(
        Context.INPUT_METHOD_SERVICE
    ) as InputMethodManager
    requestFocus()
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val inputMethodManager = context?.getSystemService(
        Context.INPUT_METHOD_SERVICE
    ) as? InputMethodManager

    if (inputMethodManager?.isActive != true) {
        return
    }
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}