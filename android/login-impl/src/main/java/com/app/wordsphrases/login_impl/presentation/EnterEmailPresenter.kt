package com.app.wordsphrases.login_impl.presentation

import com.app.wordsphrases.login_impl.R
import com.app.wordsphrases.login_impl.di.EnterEmailComponent
import com.app.wordsphrases.login_impl.domain.use_case.IsEmailValid
import com.wordphrases.domain.usecase.auth.SendLoginLinkToEmail
import kotlinx.coroutines.launch
import moxy.*
import javax.inject.Inject

class EnterEmailPresenter @Inject constructor(
    private val isEmailValid: IsEmailValid,
    private val sendLoginLinkToEmail: SendLoginLinkToEmail,
) : MvpPresenter<EnterEmailView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setSendLinkButtonDisabled()
    }

    fun onEmailInput(email: String) {
        val sendLinkButtonEnabled = isEmailValid(email)
        if (sendLinkButtonEnabled) {
            viewState.setSendLinkButtonEnabled()
        } else {
            viewState.setSendLinkButtonDisabled()
        }
    }

    fun onSendEmailButtonClick(email: String) {
        presenterScope.launch {
            viewState.showLoader()
            val result = sendLoginLinkToEmail(email)
            viewState.hideLoader()
            if (result.isSuccess) {
                viewState.emailWasSent(email)
            } else {
                viewState.showMessage(R.string.error_happened)
            }
        }
    }

    fun onResendClicked() {
        viewState.showInputForEmail()
    }

    override fun onDestroy() {
        super.onDestroy()

        EnterEmailComponent.clear()
    }
}