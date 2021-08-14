package com.app.wordsphrases.add_word_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.add_word_api.EnterWordRouter
import com.app.wordsphrases.add_word_impl.presentation.enter_word_screen.EnterWordFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class EnterWordRouterImpl @Inject constructor() : EnterWordRouter {

    override fun getScreen(): SupportAppScreen {
        return object: SupportAppScreen() {

            override fun getScreenKey(): String {
                return EnterWordFragment::class.java.simpleName
            }

            override fun getFragment(): Fragment {
                return EnterWordFragment()
            }
        }
    }
}