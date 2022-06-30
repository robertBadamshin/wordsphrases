package com.app.wordsphrases.core

import android.content.Context
import com.app.wordsphrases.add_word_api.di.AddWordApi
import com.app.wordsphrases.core.di.MainApi
import com.app.wordsphrases.dictionary_api.DictionaryApi
import com.app.wordsphrases.email_sender_api.EmailSenderApi
import com.app.wordsphrases.home_api.HomeApi
import com.app.wordsphrases.login_api.LoginApi
import com.app.wordsphrases.remote_api.RemoteApi
import com.app.wordsphrases.select_language_api.SelectLanguageApi
import com.app.wordsphrases.stories_api.StoriesApi

interface AppComponent :
    AddWordApi,
    HomeApi,
    RemoteApi,
    StoriesApi,
    SelectLanguageApi,
    EmailSenderApi,
    LoginApi,
    MainApi,
    DictionaryApi {

    fun provideContext(): Context
}