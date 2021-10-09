package com.app.wordsphrases.add_word_impl.domain

import java.util.UUID
import javax.inject.Inject

class ClearSelfAddWordComponent @Inject constructor(
    private val uuid: UUID,
    private val clearAddWordComponent: ClearAddWordComponent,
) {

    operator fun invoke() {
        clearAddWordComponent(uuid)
    }
}