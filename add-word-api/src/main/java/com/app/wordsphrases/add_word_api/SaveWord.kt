package com.app.wordsphrases.add_word_api

import com.app.wordsphrases.entity.ResultWrapper

interface SaveWord {

    suspend operator fun invoke(text: String, translation: String, image: WordImage?): ResultWrapper<Unit>
}