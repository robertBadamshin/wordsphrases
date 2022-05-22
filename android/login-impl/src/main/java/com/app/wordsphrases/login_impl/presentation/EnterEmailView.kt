package com.app.wordsphrases.login_impl.presentation

import androidx.annotation.StringRes
import moxy.MvpView
import moxy.viewstate.strategy.*
import moxy.viewstate.strategy.alias.*

private const val showLoaderTag = "showLoaderTag"
private const val setSendLinkButtonEnabledTag = "setSendLinkButtonEnabledTag"
private const val setScreenStateTag = "setScreenStateTag"

@AddToEndSingle
interface EnterEmailView : MvpView {

    @StateStrategyType(value = AddToEndSingleTagStrategy::class, tag = setSendLinkButtonEnabledTag)
    fun setSendLinkButtonDisabled()

    @StateStrategyType(value = AddToEndSingleTagStrategy::class, tag = setSendLinkButtonEnabledTag)
    fun setSendLinkButtonEnabled()

    @OneExecution
    fun showMessage(@StringRes messageRes: Int)

    @StateStrategyType(value = AddToEndSingleTagStrategy::class, tag = setScreenStateTag)
    fun emailWasSent(email: String)

    @StateStrategyType(value = AddToEndSingleTagStrategy::class, tag = setScreenStateTag)
    fun showInputForEmail()

    @StateStrategyType(value = AddToEndSingleTagStrategy::class, tag = showLoaderTag)
    fun showLoader()

    @StateStrategyType(value = AddToEndSingleTagStrategy::class, tag = showLoaderTag)
    fun hideLoader()
}