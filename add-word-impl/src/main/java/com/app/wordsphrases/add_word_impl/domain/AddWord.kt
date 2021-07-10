package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import com.app.wordsphrases.add_word_impl.domain.entity.Word
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class AddWord @Inject constructor(
    private val getImage: GetImage,
    private val addWordRepository: AddWordRepository,
) {

    suspend operator fun invoke(text: String, translation: String) {
        val image = getImage().firstOrNull()

        val result = addWordRepository.addWord(text, translation, image)
        if (result.isSuccess) {
            val addWordResult = result.requireData()
            val word = Word(
                id = addWordResult.id,
                createdAt = addWordResult.createdAt,
                text = text,
                translation = translation,
                imageUrl = addWordResult.imageUrl
            )

        } else {

        }
    }
}