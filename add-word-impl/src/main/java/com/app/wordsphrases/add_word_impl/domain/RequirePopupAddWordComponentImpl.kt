package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.domain.RequirePopupAddWordComponent
import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import javax.inject.Inject

class RequirePopupAddWordComponentImpl @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) : RequirePopupAddWordComponent {

    override operator fun invoke() {
        addWordComponentsRepository.requirePopupAddWordComponent()
    }
}