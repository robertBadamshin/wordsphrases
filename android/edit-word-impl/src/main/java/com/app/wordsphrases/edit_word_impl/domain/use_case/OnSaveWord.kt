package com.app.wordsphrases.edit_word_impl.domain.use_case

import com.app.wordsphrases.edit_word_api.domain.entity.EditWordType
import com.app.wordsphrases.edit_word_impl.data.EditWordRepository
import com.wordphrases.domain.usecase.*
import javax.inject.Inject

class OnSaveWord @Inject constructor(
    private val editWordRepository: EditWordRepository,
    private val saveNewWord: SaveNewWord,
    private val getCurrentWordText: GetCurrentWordText,
    private val requireExistingWord: RequireExistingWord,
    private val editWordType: EditWordType,
    private val updateWord: UpdateWord,
) {

    operator fun invoke() {
        val wordText = getCurrentWordText()

        val translations = editWordRepository.getCurrentTranslations()
            .filter { translation -> translation.text.isNotBlank() }
            .map { translation -> translation.text }

        val comment = editWordRepository.getCommentText()

        when (editWordType) {
            is EditWordType.AddWord -> {
                saveNewWord(
                    wordText = wordText,
                    currentTimeMilliseconds = System.currentTimeMillis(),
                    comment = comment,
                    translations = translations,
                )
            }
            is EditWordType.EditWord -> {
                val existingWord = requireExistingWord()

                updateWord(
                    existingWord = existingWord,
                    wordText = wordText,
                    comment = comment,
                    translations = translations,
                )
            }
        }


    }
}