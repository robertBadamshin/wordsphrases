package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.wordphrases.domain.usecase.SaveNewWord
import javax.inject.Inject

class OnSaveWord @Inject constructor(
    private val addWordRepository: AddWordRepository,
    private val saveNewWord: SaveNewWord,
) {

    operator fun invoke() {
        val wordText = addWordRepository.getCurrentWordText()

        val translations = addWordRepository.getCurrentTranslations()
            .filter { translation -> translation.text.isNotBlank() }
            .map { translation -> translation.text }

        val comment = addWordRepository.getCommentText()

        saveNewWord(
            wordText = wordText,
            currentTimeMilliseconds = System.currentTimeMillis(),
            comment = comment,
            translations = translations,
        )

    }
}