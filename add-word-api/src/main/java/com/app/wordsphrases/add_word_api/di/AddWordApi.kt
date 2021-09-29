package com.app.wordsphrases.add_word_api.di

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.GetWords
import com.app.wordsphrases.add_word_api.SelectTranslationStarter
import com.app.wordsphrases.add_word_api.domain.CreateAddWordComponent
import com.app.wordsphrases.add_word_api.domain.CreatePopupAddWordComponent
import com.app.wordsphrases.add_word_api.domain.RequireAddWordComponent
import com.app.wordsphrases.add_word_api.domain.RequirePopupAddWordComponent

interface AddWordApi {

    val enterWordStarter: EnterWordStarter

    val selectTranslationStarter: SelectTranslationStarter

    val getWords: GetWords

    val createAddWordComponent: CreateAddWordComponent

    val requireAddWordComponent: RequireAddWordComponent

    val createPopupAddWordComponent: CreatePopupAddWordComponent

    val requirePopupAddWordComponent: RequirePopupAddWordComponent
}