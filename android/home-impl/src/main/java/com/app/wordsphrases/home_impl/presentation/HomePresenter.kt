package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.home_api.HomeNavigationQualifier
import com.app.wordsphrases.stories_api.StoriesStarter
import com.wordphrases.Platform
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val storiesStarter: StoriesStarter,
    @HomeNavigationQualifier private val router: Router,
) : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Platform().platform

        val screen = storiesStarter.getScreen()
        router.newRootScreen(screen)
    }
}