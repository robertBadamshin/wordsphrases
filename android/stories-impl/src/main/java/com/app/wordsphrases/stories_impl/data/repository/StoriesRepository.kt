package com.app.wordsphrases.stories_impl.data.repository

import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.entity.word.WordOld
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@FeatureScope
class StoriesRepository @Inject constructor() {

    private var wordPositionFlow = MutableStateFlow(0)
    private var wordsFlow = MutableStateFlow<List<WordOld>>(emptyList())

    fun setWords(words: List<WordOld>) {
        wordsFlow.value = words
    }

    fun getWords(): Flow<List<WordOld>> {
        return wordsFlow
    }

    fun getCurrentsWords(): List<WordOld> {
        return wordsFlow.value
    }

    fun setWordPosition(position: Int) {
        wordPositionFlow.value = position
    }

    fun getWordPosition(): Flow<Int> {
        return wordPositionFlow
    }

    fun getCurrentWordPosition(): Int {
        return wordPositionFlow.value
    }
}