package com.app.wordsphrases.edit_word_api

import com.app.wordsphrases.edit_word_api.domain.entity.EditWordComponentType
import java.io.Serializable

data class EditWordInitParams(
    val type: EditWordComponentType,
): Serializable