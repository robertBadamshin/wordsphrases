package com.app.wordsphrases.translation_impl.domain

import javax.inject.Inject

class CountWordsInText @Inject constructor() {

    operator fun invoke(text: String): Int {
        return text.split("\\s+".toRegex()).size
    }
}