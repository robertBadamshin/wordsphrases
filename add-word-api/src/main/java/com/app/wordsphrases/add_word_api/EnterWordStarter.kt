package com.app.wordsphrases.add_word_api

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import ru.terrakok.cicerone.android.support.SupportAppScreen

interface EnterWordStarter {

    fun getScreen(innerComponent: AddWordInnerComponent): SupportAppScreen
}