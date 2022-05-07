package com.app.wordsphrases.add_word_impl.data

import android.content.Context
import android.graphics.BitmapFactory
import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.data.datasource.SaveWordDataSource
import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.entity.word.WordDbEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject


class SaveWordRepository @Inject constructor(
    private val saveWordDataSource: SaveWordDataSource,
    private val context: Context,
) {

    suspend fun addWord(text: String, translations: List<String>, image: WordImage?): ResultWrapper<Long> {
        val imageString = sameImageToFileSystem(image)

        val wordDbEntity = WordDbEntity(
            word = text,
            translations = translations,
            imageUrl = imageString,
            createdAt = System.currentTimeMillis(),
        )

        return withContext(Dispatchers.IO) {
            val result = saveWordDataSource.saveWord(wordDbEntity)
            ResultWrapper.createSuccess(result)
        }
    }

    private fun sameImageToFileSystem(image: WordImage?): String? {
        try {
            return when (image) {
                is WordImage.BitmapWordImage -> {
                    saveWordDataSource.saveImage(
                        bitmap = image.bitmap,
                        imageName = System.currentTimeMillis().toString(),
                    )
                }
                is WordImage.FileWordImage -> {
                    val bytes = context.contentResolver
                        .openInputStream(image.uri)
                        ?.buffered()
                        ?.use { stream -> stream.readBytes() }

                    val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes!!.size)
                    saveWordDataSource.saveImage(
                        bitmap = bitmap,
                        imageName = System.currentTimeMillis().toString(),
                    )
                }
                null -> null
            }
        } catch (exception: IOException) {
            return null
        }
    }
}