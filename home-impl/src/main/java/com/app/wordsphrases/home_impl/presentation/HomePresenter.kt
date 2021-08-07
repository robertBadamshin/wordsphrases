package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.add_word_api.AddWordRouter
import com.app.wordsphrases.stories_api.StoriesStarter
import moxy.MvpPresenter
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val addWordRouter: AddWordRouter,
    private val storiesStarter: StoriesStarter,
) : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val screen = storiesStarter.getScreen()
        viewState.setHomeScreen(screen)
    }

    fun openAddWord() {
        val screen = addWordRouter.getScreen()
        viewState.openScreen(screen)
    }
}