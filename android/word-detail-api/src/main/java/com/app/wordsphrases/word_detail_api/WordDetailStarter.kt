package com.app.wordsphrases.word_detail_api

import com.wordphrases.domain.entity.WordId
import ru.terrakok.cicerone.android.support.SupportAppScreen

interface WordDetailStarter {

    fun getScreen(wordId: WordId): SupportAppScreen
}