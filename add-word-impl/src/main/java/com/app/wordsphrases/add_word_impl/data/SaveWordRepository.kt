package com.app.wordsphrases.add_word_impl.data

import android.content.Context
import android.graphics.BitmapFactory
import com.app.wordsphrases.add_word_api.WordImage
import com.app.wordsphrases.add_word_impl.data.datasource.SaveWordDataSource
import com.app.wordsphrases.add_word_impl.data.entity.WordDbEntity
import com.app.wordsphrases.entity.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject


class SaveWordRepository @Inject constructor(
    private val saveWordDataSource: SaveWordDataSource,
    private val context: Context,
) {

    suspend fun addWord(text: String, translation: String, image: WordImage?): ResultWrapper<Unit> {
        val imageString = sameImageToFileSystem(image)

        val wordDbEntity = WordDbEntity(
            word = text,
            translation = translation,
            imageUrl = imageString,
            createdAt = System.currentTimeMillis(),
        )

        val result = withContext(Dispatchers.IO) {
            saveWordDataSource.saveWord(wordDbEntity)
        }

        return ResultWrapper.createSuccess(Unit)
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