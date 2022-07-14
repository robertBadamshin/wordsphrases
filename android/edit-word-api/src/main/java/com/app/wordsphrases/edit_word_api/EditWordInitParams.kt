package com.app.wordsphrases.edit_word_api

import com.app.wordsphrases.edit_word_api.domain.entity.EditWordType
import java.io.Serializable

data class EditWordInitParams(
    val type: EditWordType,
): Serializable