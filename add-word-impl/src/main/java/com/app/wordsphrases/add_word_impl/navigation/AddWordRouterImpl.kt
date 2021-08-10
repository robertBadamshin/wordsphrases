package com.app.wordsphrases.add_word_impl.navigation

import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.add_word_api.AddWordRouter
import com.app.wordsphrases.add_word_impl.presentation.add_word_screen.AddWordFragment
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordFragment
import javax.inject.Inject

class AddWordRouterImpl @Inject constructor() : AddWordRouter {

    override fun getScreen(): NavigationScreen {
        val fragment = EnterWordFragment()

        return NavigationScreen(
            fragment = fragment,
        )
    }
}