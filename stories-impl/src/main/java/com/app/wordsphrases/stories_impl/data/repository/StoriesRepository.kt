package com.app.wordsphrases.stories_impl.data.repository

import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.entity.word.Word
import com.app.wordsphrases.entity.word.toDomainEntity
import com.app.wordsphrases.stories_impl.data.datasource.GetWordsDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@FeatureScope
class StoriesRepository @Inject constructor() {

    private var wordPositionFlow = MutableStateFlow(0)
    private var wordsFlow = MutableStateFlow<List<Word>>(emptyList())

    fun setWords(words: List<Word>) {
        wordsFlow.value = words
    }

    fun getWords(): Flow<List<Word>> {
        return wordsFlow
    }

    fun getCurrentsWords(): List<Word> {
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