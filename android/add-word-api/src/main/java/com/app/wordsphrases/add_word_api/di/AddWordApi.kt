package com.app.wordsphrases.add_word_api.di

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.SelectTranslationStarter

interface AddWordApi {

    val enterWordStarter: EnterWordStarter

    val selectTranslationStarter: SelectTranslationStarter
}