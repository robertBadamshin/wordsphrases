package com.app.wordsphrases.select_language_impl.di.navigation

import androidx.fragment.app.Fragment
import com.app.wordsphrases.select_language_api.SelectLanguageStarter
import com.app.wordsphrases.select_language_impl.presentation.LanguagePairFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class SelectLanguageStarterImpl@Inject constructor() : SelectLanguageStarter {

    override fun getScreen(): SupportAppScreen {
        return object : SupportAppScreen() {

            override fun getScreenKey(): String {
                return LanguagePairFragment::class.java.simpleName
            }

            override fun getFragment(): Fragment {
               return LanguagePairFragment()
            }
        }
    }
}