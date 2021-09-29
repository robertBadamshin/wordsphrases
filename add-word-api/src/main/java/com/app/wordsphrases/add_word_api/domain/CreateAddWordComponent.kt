package com.app.wordsphrases.add_word_api.domain

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent

interface CreateAddWordComponent {

    operator fun invoke(innerComponent: AddWordInnerComponent)
}