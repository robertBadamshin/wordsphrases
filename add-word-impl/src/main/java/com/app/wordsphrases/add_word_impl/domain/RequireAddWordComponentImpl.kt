package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_api.domain.RequireAddWordComponent
import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import javax.inject.Inject

class RequireAddWordComponentImpl @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) : RequireAddWordComponent {

    override operator fun invoke() {
        addWordComponentsRepository.requireAddWordComponent()
    }
}