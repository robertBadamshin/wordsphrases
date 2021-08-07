package com.app.wordsphrases.add_word_impl.data.datasource

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import com.app.wordsphrases.entity.word.WordDbEntity
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject


class SaveWordDataSource @Inject constructor(
    private val insertWordDao: InsertWordDao,
    // TODO avoid context
    private val context: Context,
) {

    fun saveImage(bitmap: Bitmap, imageName: String): String? {
        return try {
            //
            val path = File(context.filesDir, "WordsPhrases" + File.separator.toString() + "Images")
            if (!path.exists()) {
                path.mkdirs()
            }
            val outFile = File(path, "$imageName.jpeg")
            val outputStream = FileOutputStream(outFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.close()

            outFile.path
        } catch (exception: FileNotFoundException) {
            Log.e("TAG", "Saving received message failed with", exception)
            null
        } catch (exception: IOException) {
            Log.e("TAG", "Saving received message failed with", exception)
            null
        }
    }

    fun saveWord(word: WordDbEntity): Long {
        insertWordDao.insertWord(word)
        // TODO make params
        return 1
    }
}