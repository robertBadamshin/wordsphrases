package com.app.wordsphrases.add_word_api

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import ru.terrakok.cicerone.android.support.SupportAppScreen

interface EnterWordStarter {

    fun getScreen(type: AddWordComponentType): SupportAppScreen

    fun initComponent(type: AddWordComponentType, innerComponent: AddWordInnerComponent)
}