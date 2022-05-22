package com.app.wordsphrases.presentation

import com.app.wordsphrases.home_api.HomeRouter
import com.app.wordsphrases.login_api.EnterEmailStarter
import com.app.wordsphrases.navigation.NavigationScreen
import com.wordphrases.domain.usecase.auth.*
import kotlinx.coroutines.launch
import moxy.*
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val homeRouter: HomeRouter,
    private val enterEmailStarter: EnterEmailStarter,
    private val isAuthorized: IsAuthorized,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        if (isAuthorized()) {
            viewState.start(homeRouter.getScreen())
        } else {
            openLoginScreen()
        }
    }

    fun startEmailLogin(emailLink: String) {
        presenterScope.launch {
            val result = AuthenticateUser().invoke(emailLink)
            if (result.isSuccess) {
                viewState.start(homeRouter.getScreen())
            } else {
                openLoginScreen()
            }
        }
    }


    // todo make on support app screen
    private fun openLoginScreen() {
        val navigationScreen = NavigationScreen(
            fragment = enterEmailStarter.getScreen().fragment
        )
        viewState.start(navigationScreen)
    }
}
