package com.app.wordsphrases.add_word_impl.navigation

import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.add_word_api.AddWordRouter
import com.app.wordsphrases.add_word_impl.presentation.AddWordFragment
import javax.inject.Inject

class AddWordRouterImpl @Inject constructor() : AddWordRouter {

    override fun getScreen(): NavigationScreen {
        val fragment = AddWordFragment()

        return NavigationScreen(
            fragment = fragment,
        )
    }
}