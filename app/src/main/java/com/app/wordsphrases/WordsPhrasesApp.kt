package com.app.wordsphrases

import com.app.wordsphrases.core.BaseWordsPhrasesApp
import com.app.wordsphrases.di.DaggerAppComponentImpl

@Suppress("unused")
class WordsPhrasesApp : BaseWordsPhrasesApp() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponentImpl.factory().create(context = this)
    }
}