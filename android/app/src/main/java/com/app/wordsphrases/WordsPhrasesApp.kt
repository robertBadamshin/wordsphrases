package com.app.wordsphrases

import com.app.wordsphrases.core.BaseWordsPhrasesApp
import com.app.wordsphrases.di.DaggerAppComponentImpl
import com.wordphrases.data.AuthPreferences
import com.wordphrases.di.appContextForDatabase

@Suppress("unused")
class WordsPhrasesApp : BaseWordsPhrasesApp() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponentImpl.factory().create(
            context = this,
        )

        appContextForDatabase = this
        AuthPreferences.init(this)
    }
}