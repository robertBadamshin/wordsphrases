package com.app.wordsphrases.popup_translator_impl.use_case

import com.app.wordsphrases.popup_translator_impl.data.repository.PopupTranslatorRepository
import javax.inject.Inject

class SetWordText @Inject constructor(
    private val popupTranslatorRepository: PopupTranslatorRepository,
) {

    operator fun invoke(text: String) {
        popupTranslatorRepository.setWordText(text)
    }
}