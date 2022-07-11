package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import javax.inject.Inject

class SetWordText @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(text: String) {
        editWordRepository.setWordText(text)
    }
}