package com.app.wordsphrases.presentation

import com.app.wordsphrases.home_api.HomeRouter
import com.app.wordsphrases.login_api.EnterEmailStarter
import com.app.wordsphrases.navigation.NavigationScreen
import com.wordphrases.domain.entity.AuthState
import com.wordphrases.domain.usecase.auth.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moxy.*
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val homeRouter: HomeRouter,
    private val enterEmailStarter: EnterEmailStarter,
    private val subscribeForAuthState: SubscribeForAuthState,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        presenterScope.launch {
            subscribeForAuthState()
                .collectLatest { state ->
                    when (state) {
                        AuthState.Authenticated -> viewState.start(homeRouter.getScreen())
                        AuthState.NotAuthenticated -> openLoginScreen()
                    }
                }
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
