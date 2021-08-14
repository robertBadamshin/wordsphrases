package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.stories_api.StoriesStarter
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val storiesStarter: StoriesStarter,
    private val router: Router,
) : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val screen = storiesStarter.getScreen()
        router.newRootScreen(screen)
    }

    fun onBackStackChanged(entriesCount: Int) {
        val hasEntries = entriesCount > 0
        viewState.updateBackPressedNestedNavigationEnabled(hasEntries)
    }
}