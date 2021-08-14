package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.add_word_api.EnterWordRouter
import com.app.wordsphrases.stories_api.StoriesStarter
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val enterWordRouter: EnterWordRouter,
    private val storiesStarter: StoriesStarter,
    private val router: Router,
) : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val screen = storiesStarter.getScreen()
        router.newRootScreen(screen)
    }

    fun openEnterWord() {
        val screen = enterWordRouter.getScreen()
        router.navigateTo(screen)
    }

    fun onBackStackChanged(entriesCount: Int) {
        val hasEntries = entriesCount > 0
        viewState.updateBackPressedNestedNavigationEnabled(hasEntries)
    }
}