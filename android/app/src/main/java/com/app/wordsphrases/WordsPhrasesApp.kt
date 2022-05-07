package com.app.wordsphrases

import com.app.wordsphrases.add_word_impl.di.database.WordDatabaseComponent
import com.app.wordsphrases.core.BaseWordsPhrasesApp
import com.app.wordsphrases.di.DaggerAppComponentImpl

@Suppress("unused")
class WordsPhrasesApp : BaseWordsPhrasesApp() {

    override fun onCreate() {
        super.onCreate()

        WordDatabaseComponent.init(context = this)
        appComponent = DaggerAppComponentImpl.factory().create(
            context = this,
            WordDatabaseComponent.require(),
        )
    }
}