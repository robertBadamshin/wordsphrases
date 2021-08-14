package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.entity.RequestStateWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@FeatureScope
class WordRepository @Inject constructor() {

    private val translationsFlow = MutableStateFlow<RequestStateWrapper<List<String>>?>(null)
    private val selectedTranslationFlow = MutableStateFlow<String?>(null)
    private val wordImageFlow = MutableStateFlow<WordImage?>(null)
    private val creationResultFlow = MutableSharedFlow<RequestStateWrapper<Unit>>()
    private val wordTextFlow = MutableStateFlow<String?>(null)

    fun getTranslations(): Flow<RequestStateWrapper<List<String>>?> {
        return translationsFlow
    }

    fun setTranslations(translations: RequestStateWrapper<List<String>>?) {
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
        creationResultFlow.tryEmit(wrapper)
    }

    fun getCreationResult(): Flow<RequestStateWrapper<Unit>> {
        return creationResultFlow
    }

    fun setSelectedTranslation(translation: String) {
        selectedTranslationFlow.value = translation
    }

    fun clearSelectedTranslation() {
        selectedTranslationFlow.value = null
    }

    fun getSelectedTranslation(): Flow<String?> {
        return selectedTranslationFlow
    }

    fun requireSelectedTranslation(): String {
        return selectedTranslationFlow.value!!
    }

    fun setWordText(text: String?) {
        wordTextFlow.value = text
    }

    fun getWordText(): Flow<String?> {
        return wordTextFlow
    }
}