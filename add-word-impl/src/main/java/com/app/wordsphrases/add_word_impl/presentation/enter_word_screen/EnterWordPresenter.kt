package com.app.wordsphrases.add_word_impl.presentation.enter_word_screen

import com.app.wordsphrases.add_word_impl.domain.GetAddWordResult
import com.app.wordsphrases.add_word_impl.domain.OnTranslateTextClick
import com.app.wordsphrases.entity.RequestErrorStateWrapper
import com.app.wordsphrases.entity.RequestLoadingStateWrapper
import com.app.wordsphrases.entity.RequestSuccessStateWrapper
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class EnterWordPresenter @Inject constructor(
    private val onTranslateTextClick: OnTranslateTextClick,
    private val getAddWordResult: GetAddWordResult,
) : MvpPresenter<EnterWordView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getAddWordResult()
            .onEach { wrapper ->
                when (wrapper) {
                    is RequestSuccessStateWrapper -> {
                        viewState.showMessage("Success")
                        // TODO add routing
                    }
                    is RequestErrorStateWrapper -> {
                        viewState.showMessage("Error")
                    }
                    is RequestLoadingStateWrapper -> {
                        // TODO nothing
                    }
                }
            }
            .launchIn(presenterScope)
    }

    fun onTranslateClick(textToTranslate: String?) {
        presenterScope.launch {
            if (textToTranslate.isNullOrEmpty()) {
                return@launch
            }

            onTranslateTextClick(textToTranslate)
        }
    }
}