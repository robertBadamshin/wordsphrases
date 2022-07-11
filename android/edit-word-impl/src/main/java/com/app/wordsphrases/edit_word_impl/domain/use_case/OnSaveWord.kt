package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import com.wordphrases.domain.usecase.SaveNewWord
import javax.inject.Inject

class OnSaveWord @Inject constructor(
    private val editWordRepository: EditWordRepository,
    private val saveNewWord: SaveNewWord,
    private val getCurrentWordText: GetCurrentWordText,
) {

    operator fun invoke() {
        val wordText = getCurrentWordText()

        val translations = editWordRepository.getCurrentTranslations()
            .filter { translation -> translation.text.isNotBlank() }
            .map { translation -> translation.text }

        val comment = editWordRepository.getCommentText()

        saveNewWord(
            wordText = wordText,
            currentTimeMilliseconds = System.currentTimeMillis(),
            comment = comment,
            translations = translations,
        )

    }
}