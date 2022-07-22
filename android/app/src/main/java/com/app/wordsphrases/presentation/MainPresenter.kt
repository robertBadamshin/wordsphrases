package com.app.wordsphrases.presentation

import com.app.wordsphrases.R
import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.home_api.HomeStarter
import com.app.wordsphrases.login_api.EnterEmailStarter
import com.app.wordsphrases.navigation.WordsPhrasesRouter
import com.app.wordsphrases.select_language_api.SelectLanguageStarter
import com.wordphrases.domain.entity.AuthState
import com.wordphrases.domain.usecase.auth.*
import com.wordphrases.domain.usecase.language_pair.GetCurrentSelectedLanguagePair
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moxy.*
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val selectLanguageStarter: SelectLanguageStarter,
    private val enterEmailStarter: EnterEmailStarter,
    private val subscribeForAuthState: SubscribeForAuthState,
    private val getCurrentSelectedLanguagePair: GetCurrentSelectedLanguagePair,
    @MainNavigationQualifier private val router: WordsPhrasesRouter,
    private val homeStarter: HomeStarter,
    private val authenticateUser: AuthenticateUser,
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
            val result = authenticateUser(emailLink)
            if (result.isSuccess) {
                proceedAfterLogin()
            } else {
                viewState.showToast(R.string.login_was_unsuccessful)
                openLoginScreen()
            }
        }
    }

    private fun proceedAfterLogin() {
        val languagePair = getCurrentSelectedLanguagePair()
        if (languagePair == null) {
            router.replaceScreen(selectLanguageStarter.getLanguagePairScreen())
        } else {
            val screen = homeStarter.getScreen()
            router.replaceScreen(screen)
        }
    }

    private fun openLoginScreen() {
        router.replaceScreen(enterEmailStarter.getScreen())
    }
}
