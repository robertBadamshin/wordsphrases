package com.app.wordsphrases.popup_translator_impl.domain.use_case

import com.app.wordsphrases.entity.RequestStateWrapper
import com.app.wordsphrases.popup_translator_impl.data.repository.PopupTranslatorRepository
import com.app.wordsphrases.translation_api.domain.Translation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTranslations @Inject constructor(
    private val popupTranslatorRepository: PopupTranslatorRepository,
) {

    operator fun invoke(): Flow<RequestStateWrapper<List<Translation>>?> {
        return popupTranslatorRepository.getTranslations()
    }
}