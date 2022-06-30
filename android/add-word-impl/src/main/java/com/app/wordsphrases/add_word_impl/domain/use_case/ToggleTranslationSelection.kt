package com.app.wordsphrases.add_word_impl.domain.use_case

import com.app.wordsphrases.add_word_impl.data.AddWordRepository
import javax.inject.Inject

class ToggleTranslationSelection @Inject constructor(
    private val addWordRepository: AddWordRepository,
    private val requireSelectedTranslationsIds: RequireSelectedTranslationsIds,
) {

    // TODO make mutex?
    operator fun invoke(id: Int) {
        val ids = requireSelectedTranslationsIds().toMutableSet()

        if (ids.contains(id)) {
            ids.remove(id)
        } else {
            ids.add(id)

        }
        addWordRepository.setSelectedTranslationsIds(ids)
    }
}