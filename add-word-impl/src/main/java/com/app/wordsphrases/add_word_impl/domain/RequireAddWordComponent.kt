package com.app.wordsphrases.add_word_impl.domain

import com.app.wordsphrases.add_word_impl.data.AddWordComponentsRepository
import com.app.wordsphrases.add_word_impl.di.AddWordComponent
import javax.inject.Inject

class RequireAddWordComponent @Inject constructor(
    private val addWordComponentsRepository: AddWordComponentsRepository,
) {

    operator fun invoke(): AddWordComponent {
        return addWordComponentsRepository.requireAddWordComponent()
    }
}