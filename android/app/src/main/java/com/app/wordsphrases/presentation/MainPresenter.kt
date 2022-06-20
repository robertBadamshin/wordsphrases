package com.app.wordsphrases.presentation

import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.login_api.EnterEmailStarter
import com.app.wordsphrases.select_language_api.SelectLanguageStarter
import com.wordphrases.domain.entity.AuthState
import com.wordphrases.domain.usecase.auth.*
import com.wordphrases.domain.usecase.language_pair.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val selectLanguageStarter: SelectLanguageStarter,
    private val enterEmailStarter: EnterEmailStarter,
    private val subscribeForAuthState: SubscribeForAuthState,
    private val getCurrentSelectedLanguagePair: GetCurrentSelectedLanguagePair,
    private val createDefaultLanguagePair: CreateDefaultLanguagePair,
    @MainNavigationQualifier private val router: Router,
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
            router.replaceScreen(selectLanguageStarter.getLanguagePairScreen())
        }
    }

    private fun openLoginScreen() {
        router.replaceScreen(enterEmailStarter.getScreen())
    }
}
