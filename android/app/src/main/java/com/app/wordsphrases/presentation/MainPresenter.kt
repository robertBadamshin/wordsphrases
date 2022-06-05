package com.app.wordsphrases.presentation

import com.app.wordsphrases.home_api.HomeRouter
import com.app.wordsphrases.login_api.EnterEmailStarter
import com.app.wordsphrases.navigation.NavigationScreen
import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageType
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import com.app.wordsphrases.select_language_impl.presentation.SelectLanguageFragment
import com.wordphrases.domain.entity.AuthState
import com.wordphrases.domain.usecase.auth.*
import com.wordphrases.domain.usecase.language_pair.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moxy.*
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val homeRouter: HomeRouter,
    private val enterEmailStarter: EnterEmailStarter,
    private val subscribeForAuthState: SubscribeForAuthState,
    private val getCurrentSelectedLanguagePair: GetCurrentSelectedLanguagePair,
    private val createDefaultLanguagePair: CreateDefaultLanguagePair,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        presenterScope.launch {
            subscribeForAuthState()
                .collectLatest { state ->
                    when (state) {
                        AuthState.Authenticated -> proceedAfterLogin()
                        AuthState.NotAuthenticated -> openLoginScreen()
                    }
                }
        }
    }

    fun startEmailLogin(emailLink: String) {
        presenterScope.launch {
            val result = AuthenticateUser().invoke(emailLink)
            if (result.isSuccess) {
                proceedAfterLogin()
            } else {
                openLoginScreen()
            }
        }
    }

    private fun proceedAfterLogin() {
        val languagePair = getCurrentSelectedLanguagePair()
        if (languagePair == null) {
            // TODO HANDLE REAL SELECTION
            createDefaultLanguagePair()
            proceedAfterLogin()
        } else {
            viewState.start(homeRouter.getScreen())
        }
    }

    // todo make on support app screen
    private fun openLoginScreen() {
        val navigationScreen = NavigationScreen(
            fragment = SelectLanguageFragment.newInstance(SelectLanguageInitParams(SelectLanguageType.Native)) //enterEmailStarter.getScreen().fragment
        )
        viewState.start(navigationScreen)
    }
}
