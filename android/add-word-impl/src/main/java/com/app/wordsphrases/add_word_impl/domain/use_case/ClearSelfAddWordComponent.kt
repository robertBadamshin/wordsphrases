package com.app.wordsphrases.add_word_impl.domain.use_case

import java.util.*
import javax.inject.Inject

class ClearSelfAddWordComponent @Inject constructor(
    private val uuid: UUID,
    private val clearAddWordComponent: ClearAddWordComponent,
) {

    operator fun invoke() {
        clearAddWordComponent(uuid)
    }
}