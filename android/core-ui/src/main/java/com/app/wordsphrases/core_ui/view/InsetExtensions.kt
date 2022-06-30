package com.app.wordsphrases.core_ui.view

import android.view.View
import androidx.core.graphics.Insets
import androidx.core.view.*

fun View.configureInsets() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, windowInsets ->
        val insetsMask = WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime()
        val screenInsets = windowInsets.getInsets(insetsMask)
        this.updatePadding(top = screenInsets.top, bottom = screenInsets.bottom)

        return@setOnApplyWindowInsetsListener windowInsets
    }

    val insetsCallback = object : WindowInsetsAnimationCompat.Callback(DISPATCH_MODE_STOP) {

        override fun onProgress(
            insets: WindowInsetsCompat,
            runningAnimations: MutableList<WindowInsetsAnimationCompat>
        ): WindowInsetsCompat {
            val screenInsets = getScreenInsets(insets)
            this@configureInsets.updatePadding(bottom = screenInsets.bottom)
            return insets
        }
    }

    ViewCompat.setWindowInsetsAnimationCallback(this, insetsCallback)
}

fun View.configureTopInsets() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, windowInsets ->
        val screenInsets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        this.updatePadding(top = screenInsets.top)

        return@setOnApplyWindowInsetsListener windowInsets
    }
}

private fun getScreenInsets(insets: WindowInsetsCompat): Insets {
    return insets.getInsets(WindowInsetsCompat.Type.ime() or WindowInsetsCompat.Type.systemBars())
}