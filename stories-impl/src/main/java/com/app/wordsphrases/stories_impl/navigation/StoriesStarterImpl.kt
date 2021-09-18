package com.app.wordsphrases.stories_impl.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.stories_api.StoriesStarter
import com.app.wordsphrases.popup_translator_impl.presentation.StoriesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class StoriesStarterImpl @Inject constructor() : StoriesStarter {

    override fun getScreen(): SupportAppScreen {
        return object : SupportAppScreen() {

            override fun getScreenKey(): String {
                return StoriesFragment::class.java.simpleName
            }

            override fun getFragment(): Fragment {
                return StoriesFragment()
            }
        }
    }
}