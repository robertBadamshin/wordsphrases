package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import javax.inject.Inject

class ClearSelfAddWordComponent @Inject constructor(
    private val addWordComponentType: AddWordComponentType,
    private val clearAddWordComponent: ClearAddWordComponent,
) {

    operator fun invoke() {
        clearAddWordComponent(addWordComponentType)
    }
}