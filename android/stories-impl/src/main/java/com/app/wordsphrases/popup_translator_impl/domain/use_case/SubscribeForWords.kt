package com.app.wordsphrases.popup_translator_impl.domain.use_case

import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import com.wordphrases.domain.entity.Word
import com.wordphrases.domain.usecase.GetWords
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SubscribeForWords @Inject constructor(
    private val getWords: GetWords,
    private val repository: StoriesRepository,
) {

    suspend operator fun invoke() {
        return getWords()
            .map { words ->
                words.map { word ->
                    com.app.wordsphrases.entity.word.Word(
                        id = word.wordId.toInt(),
                        createdAt = word.createdAt,
                        word = word.wordText,
                        translations = word.translations,
                        imageUrl = "",
                    )
                }
            }
            .collect { words -> repository.setWords(words) }
    }
}