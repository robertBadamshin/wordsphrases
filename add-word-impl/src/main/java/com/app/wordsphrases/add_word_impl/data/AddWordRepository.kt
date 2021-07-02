package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestStateWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@FeatureScope
class AddWordRepository @Inject constructor() {

    private val translationsFlow = MutableStateFlow<RequestStateWrapper<List<String>>?>(null)

    fun getTranslations(): Flow<RequestStateWrapper<List<String>>?> {
        return translationsFlow
    }

    fun setTranslations(translations: RequestStateWrapper<List<String>>?) {
        translationsFlow.value = translations
    }
}