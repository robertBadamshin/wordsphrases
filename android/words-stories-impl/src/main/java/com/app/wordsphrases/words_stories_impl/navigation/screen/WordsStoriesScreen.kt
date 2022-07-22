package com.app.wordsphrases.words_stories_impl.navigation.screen

import androidx.fragment.app.Fragment
import com.app.wordsphrases.words_stories_impl.presentation.WordsStoriesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class WordsStoriesScreen : SupportAppScreen() {

    override fun getFragment(): Fragment {
        return WordsStoriesFragment.newInstance()
    }

    override fun getScreenKey(): String {
        return WordsStoriesFragment::class.java.simpleName
    }
}