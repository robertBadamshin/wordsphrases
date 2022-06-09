package com.app.wordsphrases.core

import android.content.Context
import com.app.wordsphrases.add_word_api.di.AddWordApi
import com.app.wordsphrases.email_sender_api.EmailSenderApi
import com.app.wordsphrases.home_api.HomeApi
import com.app.wordsphrases.login_api.LoginApi
import com.app.wordsphrases.remote_api.RemoteApi
import com.app.wordsphrases.select_language_api.SelectLanguageApi
import com.app.wordsphrases.stories_api.StoriesApi
import com.app.wordsphrases.translation_api.TranslationApi

interface AppComponent :
    AddWordApi,
    HomeApi,
    RemoteApi,
    TranslationApi,
    StoriesApi,
    SelectLanguageApi,
    EmailSenderApi,
    LoginApi {

    fun provideContext(): Context
}