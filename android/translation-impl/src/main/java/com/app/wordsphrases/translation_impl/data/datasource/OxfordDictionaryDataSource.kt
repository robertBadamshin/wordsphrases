package com.app.wordsphrases.translation_impl.data.datasource

import javax.inject.Inject

private const val endpoint = "https://od-api.oxforddictionaries.com/api/v2"


class OxfordDictionaryDataSource @Inject constructor(

) {

    fun translateWord(languageFrom: String, languageTo: String,) {
        // TODO remove?
    }
}