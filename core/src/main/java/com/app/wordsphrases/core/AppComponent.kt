package com.app.wordsphrases.core

import android.content.Context
import com.app.wordsphrases.home_api.HomeApi
import com.app.wordsphrases.remote_api.RemoteApi
import com.app.wordsphrases.add_word_api.AddWordApi
import com.app.wordsphrases.translation_api.TranslationApi

interface AppComponent :
    AddWordApi,
    HomeApi,
    RemoteApi,
    TranslationApi {

    fun provideContext(): Context
}