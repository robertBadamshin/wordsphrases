package com.app.wordsphrases.edit_word_api

import ru.terrakok.cicerone.android.support.SupportAppScreen

interface EditWordStarter {

    fun getScreen(initParams: EditWordInitParams): SupportAppScreen
}