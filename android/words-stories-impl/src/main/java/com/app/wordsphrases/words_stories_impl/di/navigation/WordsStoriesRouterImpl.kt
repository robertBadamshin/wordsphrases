package com.app.wordsphrases.words_stories_impl.di.navigation

import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.navigation.*
import com.app.wordsphrases.words_stories_api.WordsStoriesRouter
import com.app.wordsphrases.words_stories_impl.navigation.screen.WordsStoriesScreen
import javax.inject.Inject

class WordsStoriesRouterImpl @Inject constructor(
    @MainNavigationQualifier
    private val router: WordsPhrasesRouter,
) : WordsStoriesRouter {

    override fun openScreen() {
        val screen = WordsStoriesScreen()
        router.addScreen(
            screen = screen,
            screenFragmentAnimation = ScreenFragmentAnimation.SlideTop,
        )
    }
}