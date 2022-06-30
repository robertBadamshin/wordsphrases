package com.app.wordsphrases.stories_impl.use_case

import com.app.wordsphrases.entity.word.WordOld
import com.app.wordsphrases.stories_impl.data.repository.StoriesRepository
import com.wordphrases.domain.usecase.GetWordsForStories
import com.wordphrases.domain.usecase.language_pair.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SubscribeForWords @Inject constructor(
    private val getWordsForStories: GetWordsForStories,
    private val repository: StoriesRepository,
    private val getSelectedLanguagePair: GetSelectedLanguagePair,
) {

    suspend operator fun invoke() {
        getSelectedLanguagePair()
            .flatMapLatest { languagePair ->
                getWordsForStories(languagePair.pairId)
                    .map { words ->
                        words.map { word ->
                            WordOld(
                                id = word.wordId.toInt(),
                                createdAt = word.createdAt,
                                word = word.wordText,
                                translations = word.translations,
                                imageUrl = "",
                            )
                        }
                    }
            }
            .collect { words -> repository.setWords(words) }
    }
}