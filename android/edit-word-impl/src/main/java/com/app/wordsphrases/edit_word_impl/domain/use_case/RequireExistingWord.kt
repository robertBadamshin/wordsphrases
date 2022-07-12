package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import com.wordphrases.domain.entity.Word
import javax.inject.Inject

class RequireExistingWord @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(): Word {
        return editWordRepository.requireExistingWord()
    }
}