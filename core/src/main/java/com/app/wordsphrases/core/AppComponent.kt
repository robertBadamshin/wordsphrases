package com.app.wordsphrases.core

import com.app.wordsphrases.home_api.HomeApi
import com.app.wordsphrases.remote_impl.RemoteApi
import com.app.wordsphrases.translation_api.AddWordApi
import com.app.wordsphrases.translation_api.TranslationApi

interface AppComponent :
    AddWordApi,
    HomeApi,
    RemoteApi,
    TranslationApi