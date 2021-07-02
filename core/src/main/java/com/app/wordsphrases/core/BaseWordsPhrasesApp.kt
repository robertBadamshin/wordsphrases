package com.app.wordsphrases.core

import android.app.Application

abstract class BaseWordsPhrasesApp : Application() {


    companion object {

        lateinit var appComponent: AppComponent
    }
}