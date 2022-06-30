package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.dictionary_api.DictionaryStarter
import com.app.wordsphrases.home_api.HomeNavigationQualifier
import com.app.wordsphrases.home_impl.domain.entity.HomeScreenTab
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val dictionaryStarter: DictionaryStarter,
    @HomeNavigationQualifier private val router: Router,
) : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val startScreen = dictionaryStarter.getScreen()
        router.newRootScreen(startScreen)
    }

    fun onSelectTab(homeScreenTab: HomeScreenTab) {
        val screen = when (homeScreenTab) {
            HomeScreenTab.Vocabulary -> dictionaryStarter.getScreen()
            HomeScreenTab.Folders -> dictionaryStarter.getScreen()
        }
        router.newRootScreen(screen)
    }
}