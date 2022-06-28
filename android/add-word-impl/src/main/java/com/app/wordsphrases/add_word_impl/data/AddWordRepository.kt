package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.add_word_impl.di.AddWordComponentScope
import com.app.wordsphrases.add_word_impl.domain.entity.Translation
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@AddWordComponentScope
class AddWordRepository @Inject constructor() {

    private val wordTextFlow = MutableSharedFlow<String?>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    private var commentText: String? = null
    private val translationsFlow = MutableStateFlow(emptyList<Translation>())
    private var translationId = 1

    fun setWordText(text: String) {
        wordTextFlow.tryEmit(text)
    }

    fun getWordText(): Flow<String?> {
        return wordTextFlow
    }

    fun setCommentText(text: String) {
        commentText = text
    }

    fun getCommentText(): String? {
        return commentText
    }

    fun getCurrentWordText(): String {
        return wordTextFlow.replayCache.first()
            ?: throw IllegalStateException("call only when word exists")
    }

    fun setTranslations(translations: List<Translation>) {
        translationsFlow.value = translations
    }

    fun getTranslations(): Flow<List<Translation>> {
        return translationsFlow
    }

    fun getCurrentTranslations(): List<Translation> {
        return translationsFlow.value
    }

    fun requireTranslations(): List<Translation> {
        return translationsFlow.value
    }

    fun getNextTranslationId(): Int {
        return ++translationId
    }
}