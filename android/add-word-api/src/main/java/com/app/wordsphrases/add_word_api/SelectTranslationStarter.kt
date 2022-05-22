package com.app.wordsphrases.add_word_api

import ru.terrakok.cicerone.android.support.SupportAppScreen
import java.util.*

interface SelectTranslationStarter {

    fun getScreen(uuid: UUID): SupportAppScreen
}