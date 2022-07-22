package com.app.wordsphrases.select_language_impl.navigation

import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.navigation.WordsPhrasesRouter
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import com.app.wordsphrases.select_language_impl.navigation.screen.SelectLanguageScreen
import javax.inject.Inject

class SelectLanguageFeatureRouter @Inject constructor(
    @MainNavigationQualifier private val router: WordsPhrasesRouter,
) {

    fun openSelectLanguageScreen(initParams: SelectLanguageInitParams) {
        val screen = SelectLanguageScreen(initParams)
        router.navigateTo(screen)
    }
}