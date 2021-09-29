package com.app.wordsphrases.add_word_api.di

import ru.terrakok.cicerone.Router

interface AddWordInnerComponent {

    @get:AddWordNavigationQualifier
    val router: Router
}