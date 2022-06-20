package com.app.wordsphrases.select_language_impl.presentation

import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageType
import com.app.wordsphrases.select_language_impl.navigation.SelectLanguageFeatureRouter
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import moxy.MvpPresenter
import javax.inject.Inject

private const val selectNativeLanguageKey = "selectNativeLanguageKey"
private const val selectLearningLanguageKey = "selectLearningLanguageKey"

class LanguagePairPresenter @Inject constructor(
    private val selectLanguageFeatureRouter: SelectLanguageFeatureRouter,
) : MvpPresenter<LanguagePairView>() {

    fun onNativeLanguageClick() {
        val initParams = SelectLanguageInitParams(
            selectLanguageType = SelectLanguageType.Native,
            resultKey = selectNativeLanguageKey,
        )
        viewState.startListenForNativeLanguageResult(selectNativeLanguageKey)
        selectLanguageFeatureRouter.openSelectLanguageScreen(initParams)
    }

    fun onLearningLanguageClick() {
        val initParams = SelectLanguageInitParams(
            selectLanguageType = SelectLanguageType.Learning,
            resultKey = selectLearningLanguageKey,
        )
        viewState.startListenForLearningLanguageResult(selectLearningLanguageKey)
        selectLanguageFeatureRouter.openSelectLanguageScreen(initParams)
    }
}