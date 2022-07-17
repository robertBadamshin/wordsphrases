package com.app.wordsphrases.words_stories_impl.di.navigation

import com.app.wordsphrases.words_stories_api.WordsStoriesStarter
import com.app.wordsphrases.words_stories_impl.navigation.screen.WordsStoriesScreen
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class WordsStoriesStarterImpl @Inject constructor() : WordsStoriesStarter {

    override fun getScreen(): SupportAppScreen {
        return WordsStoriesScreen()
    }
}