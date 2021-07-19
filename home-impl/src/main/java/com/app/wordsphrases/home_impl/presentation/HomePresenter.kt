package com.app.wordsphrases.home_impl.presentation

import com.app.wordsphrases.add_word_api.AddWordRouter
import moxy.MvpPresenter
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val addWordRouter: AddWordRouter,
) : MvpPresenter<HomeView>() {

    fun openAddWord() {
        val screen = addWordRouter.getScreen()
        viewState.openScreen(screen)
    }
}