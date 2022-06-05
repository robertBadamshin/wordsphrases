package com.app.wordsphrases.select_language_impl.navigation.init_params

import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageType
import java.io.Serializable

data class SelectLanguageInitParams(
    val selectLanguageType: SelectLanguageType,
) : Serializable