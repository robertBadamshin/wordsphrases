package com.app.wordsphrases.select_language_impl.presentation

import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.email_sender_api.RequestLanguageEmailSender
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageType
import com.app.wordsphrases.select_language_impl.domain.use_case.GetLanguages
import com.app.wordsphrases.select_language_impl.navigation.init_params.SelectLanguageInitParams
import com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper.LanguagesUiMapper
import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.*
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SelectLanguagePresenter @Inject constructor(
    private val getLanguages: GetLanguages,
    private val languagesUiMapper: LanguagesUiMapper,
    @MainNavigationQualifier private val router: Router,
    private val requestLanguageEmailSender: RequestLanguageEmailSender,
) : MvpPresenter<SelectLanguageView>() {

    private lateinit var initParams: SelectLanguageInitParams

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateLanguages()

        initTitle()
    }

    fun init(initParams: SelectLanguageInitParams) {
        this.initParams = initParams
    }

    private fun updateLanguages() {
        getLanguages()
            .map { languages -> languagesUiMapper.map(languages) }
            .onEach { uiModels -> viewState.showLanguages(uiModels) }
            .launchIn(presenterScope)
    }

    private fun initTitle() {
        val titleResId = when (initParams.selectLanguageType) {
            SelectLanguageType.Learning -> R.string.learning_language_title
            SelectLanguageType.Native -> R.string.native_language_title
        }
        viewState.setTitle(titleResId)
    }

    fun onLanguageSelected(language: Language) {
        viewState.setScreenResult(initParams.resultKey, language)
        router.exit()
    }

    fun onRequestLanguageClick() {
        val intent = requestLanguageEmailSender()
        viewState.startIntent(intent)
    }
}