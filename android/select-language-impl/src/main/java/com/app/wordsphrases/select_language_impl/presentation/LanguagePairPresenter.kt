package com.app.wordsphrases.select_language_impl.presentation

import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.home_api.HomeStarter
import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageType
import com.app.wordsphrases.select_language_impl.domain.use_case.*
import com.app.wordsphrases.select_language_impl.navigation.SelectLanguageFeatureRouter
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper.LanguagePairUiMapper
import com.wordphrases.domain.entity.language.Language
import com.wordphrases.domain.usecase.language_pair.SaveLanguagePair
import kotlinx.coroutines.flow.*
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

private const val selectNativeLanguageKey = "selectNativeLanguageKey"
private const val selectLearningLanguageKey = "selectLearningLanguageKey"

class LanguagePairPresenter @Inject constructor(
    private val selectLanguageFeatureRouter: SelectLanguageFeatureRouter,
    private val getSelectLanguagePairEnvironment: GetSelectLanguagePairEnvironment,
    private val languagePairUiMapper: LanguagePairUiMapper,
    private val setLearningLanguage: SetLearningLanguage,
    private val setNativeLanguage: SetNativeLanguage,
    private val saveLanguagePair: SaveLanguagePair,
    private val requireLanguagePair: RequireLanguagePair,
    @MainNavigationQualifier private val router: Router,
    private val homeStarter: HomeStarter,
) : MvpPresenter<LanguagePairView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateLanguages()
    }

    private fun updateLanguages() {
        getSelectLanguagePairEnvironment()
            .map { environment -> languagePairUiMapper.map(environment) }
            .onEach { uiModel -> viewState.setLanguages(uiModel) }
            .launchIn(presenterScope)
    }

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

    fun onLearningLanguageSelected(language: Language) {
        setLearningLanguage(language)
    }

    fun onNativeLanguageSelected(language: Language) {
        setNativeLanguage(language)
    }

    fun onSaveLanguagePairClick() {
        val languagePair = requireLanguagePair()
        saveLanguagePair(languagePair)

        val screen = homeStarter.getScreen()
        router.replaceScreen(screen)
    }
}