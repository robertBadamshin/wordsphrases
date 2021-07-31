package com.app.wordsphrases.add_word_impl.data.datasource

import com.app.wordsphrases.add_word_impl.data.entity.remote.AddWordResultRemote
import com.app.wordsphrases.add_word_impl.data.entity.request.AddWordRequest
import com.app.wordsphrases.add_word_impl.data.service.AddWordService
import com.app.wordsphrases.add_word_impl.domain.entity.WordImage
import com.app.wordsphrases.entity.ResultWrapper
import kotlinx.coroutines.delay
import javax.inject.Inject


class AddWordDataSource @Inject constructor(
    private val addWordService: AddWordService,
) {

    suspend fun addWord(text: String, translation: String, image: String?): ResultWrapper<AddWordResultRemote> {
        val request = AddWordRequest(
            text = text,
            translation = translation,
            image = image,
        )

        return addWordService.addWord(request)

        /*delay(500)

        val addWordResultRemote = AddWordResultRemote(
            id = "123",
            createdAt = 123123131L,
            imageUrl = "https://leonardo.osnova.io/71515fbd-5119-5906-8f6e-dabb54e3e7ff/-/preview/1300/-/format/webp/",
        )

        return ResultWrapper.createSuccess(addWordResultRemote)*/
    }
}