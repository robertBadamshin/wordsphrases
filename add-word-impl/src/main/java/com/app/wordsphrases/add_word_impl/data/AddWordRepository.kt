package com.app.wordsphrases.add_word_impl.data

import com.app.wordsphrases.add_word_impl.data.datasource.AddWordDataSource
import com.app.wordsphrases.add_word_impl.data.entity.remote.toDomainEntity
import com.app.wordsphrases.add_word_impl.domain.entity.AddWordResult
import com.app.wordsphrases.add_word_impl.domain.entity.Word
import com.app.wordsphrases.add_word_impl.domain.entity.WordImage
import com.app.wordsphrases.core.di.FeatureScope
import com.app.wordsphrases.entity.RequestStateWrapper
import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.entity.mapData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.w3c.dom.Text
import javax.inject.Inject

@FeatureScope
class AddWordRepository @Inject constructor(
    private val addWordDataSource: AddWordDataSource,
) {

    private val translationsFlow = MutableStateFlow<RequestStateWrapper<List<String>>?>(null)
    private val wordImageFlow = MutableStateFlow<WordImage?>(null)

    fun getTranslations(): Flow<RequestStateWrapper<List<String>>?> {
        return translationsFlow
    }

    fun setTranslations(translations: RequestStateWrapper<List<String>>?) {
        translationsFlow.value = translations
    }

    fun getImage(): Flow<WordImage?> {
        return wordImageFlow
    }

    fun setImage(image: WordImage?) {
        wordImageFlow.value = image
    }

    suspend fun addWord(text: String, translation: String, image: WordImage?): ResultWrapper<AddWordResult> {
        val result = addWordDataSource.addWord(
            text = text,
            translation = translation,
            image = image
        )

        return result.mapData { data -> data.toDomainEntity() }
    }

    fun saveWordToDatabase(word: Word) {

    }
}