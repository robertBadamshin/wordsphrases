package com.app.wordsphrases.add_word_impl.data

import android.content.Context
import android.graphics.Bitmap
import android.util.Base64
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
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.ByteArrayOutputStream
import java.io.IOException
import javax.inject.Inject

@FeatureScope
class AddWordRepository @Inject constructor(
    private val addWordDataSource: AddWordDataSource,
    private val context: Context,
) {

    private val translationsFlow = MutableStateFlow<RequestStateWrapper<List<String>>?>(null)
    private val wordImageFlow = MutableStateFlow<WordImage?>(null)
    private val addWordResultFlow = MutableSharedFlow<RequestStateWrapper<Unit>>()

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
        val imageString = getImageBase64(image)

        val result = addWordDataSource.addWord(
            text = text,
            translation = translation,
            image = imageString
        )

        return result.mapData { data -> data.toDomainEntity() }
    }

    fun setAddWordResult(wrapper: RequestStateWrapper<Unit>) {
        addWordResultFlow.tryEmit(wrapper)
    }

    fun getAddWordResult(): Flow<RequestStateWrapper<Unit>> {
        return addWordResultFlow
    }

    fun saveWordToDatabase(word: Word) {

    }

    private fun getImageBase64(image: WordImage?): String? {
        try {
            return when (image) {
                is WordImage.BitmapWordImage -> {
                    val byteArrayOutputStream = ByteArrayOutputStream()
                    image
                        .bitmap
                        .compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

                    val imageBytes = byteArrayOutputStream.toByteArray()
                    Base64.encodeToString(imageBytes, Base64.DEFAULT)
                }
                is WordImage.FileWordImage -> {
                    val bytes = context.contentResolver
                        .openInputStream(image.uri)
                        ?.buffered()
                        ?.use { stream -> stream.readBytes() }

                    Base64.encodeToString(bytes, Base64.NO_WRAP)
                }
                null -> null
            }
        } catch (exception: IOException) {
            return null
        }
    }
}