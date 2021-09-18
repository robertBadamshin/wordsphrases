package com.app.wordsphrases.popup_translator_impl.data.repository

import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.entity.RequestStateWrapper
import com.app.wordsphrases.translation_api.domain.Translation
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@FeatureScope
class PopupTranslatorRepository @Inject constructor() {

    private val translationsFlow = MutableStateFlow<RequestStateWrapper<List<Translation>>?>(null)
    private val wordTextFlow = MutableSharedFlow<String?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    fun getTranslations(): Flow<RequestStateWrapper<List<Translation>>?> {
        return translationsFlow
    }

    fun getCurrentTranslations(): RequestStateWrapper<List<Translation>> {
        return translationsFlow.value ?: throw IllegalArgumentException("call only when state exists")
    }

    fun setTranslations(translations: RequestStateWrapper<List<Translation>>?) {
        translationsFlow.value = translations
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
}