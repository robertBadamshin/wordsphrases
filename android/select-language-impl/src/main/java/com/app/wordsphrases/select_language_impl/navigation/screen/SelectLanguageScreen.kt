package com.app.wordsphrases.select_language_impl.navigation.screen

import androidx.fragment.app.Fragment
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import com.app.wordsphrases.select_language_impl.presentation.SelectLanguageFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SelectLanguageScreen(
    private val initParams: SelectLanguageInitParams,
) : SupportAppScreen() {

    override fun getFragment(): Fragment {
        return SelectLanguageFragment.newInstance(initParams)
    }

    override fun getScreenKey(): String {
        return SelectLanguageFragment::class.java.simpleName
    }
}