package com.app.wordsphrases.edit_word_api.domain.entity

import com.wordphrases.domain.entity.WordId
import java.io.Serializable

sealed class EditWordComponentType: Serializable {

    object AddWord : EditWordComponentType()

    data class EditWord(
        val wordId: WordId,
    ) : EditWordComponentType()
}