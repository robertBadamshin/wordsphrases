package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.data.datasource.GetWordsDao
import com.app.wordsphrases.translation_api.domain.Translation
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.core.utils.LazyStateFlow
import com.app.wordsphrases.entity.RequestStateWrapper
import com.app.wordsphrases.entity.word.Word
import com.app.wordsphrases.entity.word.toDomainEntity
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import javax.inject.Inject


@FeatureScope
class WordRepository @Inject constructor() {

    private val translationsFlow = MutableStateFlow<RequestStateWrapper<List<Translation>>?>(null)

    // TODO cut image
    private val wordImageFlow = MutableStateFlow<WordImage?>(null)
    private val creationResultFlow = LazyStateFlow<RequestStateWrapper<Unit>>()
    private val wordTextFlow = MutableSharedFlow<String?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val selectedTranslationsFlow = MutableStateFlow<Set<Int>>(emptySet())

    fun getTranslations(): Flow<RequestStateWrapper<List<Translation>>?> {
        return translationsFlow
    }

    fun getCurrentTranslations(): RequestStateWrapper<List<Translation>> {
        return translationsFlow.value ?: throw IllegalArgumentException("call only when state exists")
    }

    fun setTranslations(translations: RequestStateWrapper<List<Translation>>?) {
        translationsFlow.value = translations
    }

    fun getImage(): Flow<WordImage?> {
        return wordImageFlow
    }

    fun getCurrentImage(): WordImage? {
        return wordImageFlow.value
    }

    fun setImage(image: WordImage?) {
        wordImageFlow.value = image
    }

    fun setCreationResult(wrapper: RequestStateWrapper<Unit>) {
        creationResultFlow.value = wrapper
    }

    fun getCreationResult(): Flow<RequestStateWrapper<Unit>> {
        return creationResultFlow
    }

    fun setWordText(text: String) {
        wordTextFlow.tryEmit(text)
    }

    fun getWordText(): Flow<String?> {
        return wordTextFlow
    }

    fun getCurrentWordText(): String {
        return wordTextFlow.replayCache.first() ?: throw IllegalStateException("call only when word exists")
    }

    fun setSelectedTranslationsIds(ids: Set<Int>) {
        selectedTranslationsFlow.value = ids
    }

    fun getSelectedTranslationsIds(): Flow<Set<Int>> {
        return selectedTranslationsFlow
    }

    fun requireSelectedTranslationsIds(): Set<Int> {
        return selectedTranslationsFlow.value
    }
}