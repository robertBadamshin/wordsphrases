package com.app.wordsphrases.edit_word_api.domain.entity

import com.wordphrases.domain.entity.WordId
import java.io.Serializable

sealed class EditWordType: Serializable {

    object AddWord : EditWordType()

    data class EditWord(
        val wordId: WordId,
    ) : EditWordType()
}