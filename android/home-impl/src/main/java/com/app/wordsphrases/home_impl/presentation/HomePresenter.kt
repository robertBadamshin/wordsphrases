package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.home_api.HomeNavigationQualifier
import com.app.wordsphrases.home_impl.domain.entity.HomeScreenTab
import com.app.wordsphrases.stories_api.StoriesStarter
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val storiesStarter: StoriesStarter,
    @HomeNavigationQualifier private val router: Router,
) : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val startScreen = storiesStarter.getScreen()
        router.newRootScreen(startScreen)
    }

    fun onSelectTab(homeScreenTab: HomeScreenTab) {
        val screen = when (homeScreenTab) {
            HomeScreenTab.Vocabulary -> storiesStarter.getScreen()
            HomeScreenTab.Folders -> storiesStarter.getScreen()
        }
        router.newRootScreen(screen)
    }
}