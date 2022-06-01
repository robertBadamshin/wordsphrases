package com.app.wordsphrases.stories_impl.use_case

import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import com.wordphrases.domain.usecase.GetWordsForStories
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SubscribeForWords @Inject constructor(
    private val getWordsForStories: GetWordsForStories,
    private val repository: StoriesRepository,
) {

    suspend operator fun invoke() {
        return getWordsForStories()
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