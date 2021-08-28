package com.app.wordsphrases.add_word_api

interface AddWordApi {

    val enterWordStarter: EnterWordStarter

    val selectTranslationStarter: SelectTranslationStarter

    val getWords: GetWords
}