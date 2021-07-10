package com.app.wordsphrases.add_word_impl.domain.entity

import android.graphics.Bitmap
import android.net.Uri

sealed class WordImage {

    data class FileWordImage(
        val uri: Uri,
    ) : WordImage()

    data class BitmapWordImage(
        val bitmap: Bitmap,
    ) : WordImage()
}