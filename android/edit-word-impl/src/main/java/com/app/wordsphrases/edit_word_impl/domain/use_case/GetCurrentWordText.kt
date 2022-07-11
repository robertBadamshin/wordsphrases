package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import javax.inject.Inject

class GetCurrentWordText @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(): String {
        return editWordRepository.getCurrentWordText()
    }
}