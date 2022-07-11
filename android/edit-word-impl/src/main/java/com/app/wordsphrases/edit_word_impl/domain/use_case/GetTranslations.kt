package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import com.app.wordsphrases.edit_word_impl.domain.entity.Translation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTranslations @Inject constructor(
    private val editWordRepository: EditWordRepository,
) {

    operator fun invoke(): Flow<List<Translation>> {
        return editWordRepository.getTranslations()
    }
}