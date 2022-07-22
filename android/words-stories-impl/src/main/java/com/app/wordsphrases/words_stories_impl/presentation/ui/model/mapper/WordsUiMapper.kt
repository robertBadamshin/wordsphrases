package com.app.wordsphrases.words_stories_impl.presentation.ui.model.mapper

import com.app.wordsphrases.words_stories_impl.presentation.ui.model.WordUiModel
import com.wordphrases.domain.entity.Word
import javax.inject.Inject

class WordsUiMapper @Inject constructor(
    private val wordColorSchemaUiMapper: WordColorSchemaUiMapper,
) {

    fun map(words: List<Word>): List<WordUiModel> {
        return words.map { word ->
            val wordColorSchemaUiModel = wordColorSchemaUiMapper.map(word.colorSchema)

            WordUiModel(
                wordId = word.wordId,
                text = word.wordText,
                translations = word.translations,
                comment = word.comment,
                colorSchemaUiModel = wordColorSchemaUiModel,
            )
        }
    }
}