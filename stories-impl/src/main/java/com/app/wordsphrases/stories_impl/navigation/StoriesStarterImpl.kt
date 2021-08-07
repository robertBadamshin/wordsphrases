package com.app.wordsphrases.stories_impl.navigation

import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.stories_api.StoriesStarter
import com.app.wordsphrases.stories_impl.presentation.StoriesFragment
import javax.inject.Inject

class StoriesStarterImpl @Inject constructor() : StoriesStarter {

    override fun getScreen(): NavigationScreen {
        val fragment = StoriesFragment()

        return NavigationScreen(
            fragment = fragment,
        )
    }
}