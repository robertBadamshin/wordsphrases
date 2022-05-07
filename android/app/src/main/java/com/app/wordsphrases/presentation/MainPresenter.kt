package com.app.wordsphrases.presentation

import com.app.wordsphrases.home_api.HomeRouter
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val homeRouter: HomeRouter,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.start(homeRouter.getScreen())
    }
}