package com.app.wordsphrases.words_stories_impl.presentation.ui.model.mapper

import com.app.wordsphrases.words_stories_impl.R
import com.app.wordsphrases.words_stories_impl.presentation.ui.model.WordColorSchemaUiModel
import com.wordphrases.domain.entity.WordColorSchema
import javax.inject.Inject

class WordColorSchemaUiMapper @Inject constructor() {

    fun map(colorSchema: WordColorSchema): WordColorSchemaUiModel {
        return when (colorSchema) {
            WordColorSchema.Blackberry -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_blackberry,
                    wordTextColorRes = R.color.stories_surface,
                    translationTextColorRes = R.color.stories_blackberry,
                    translationBackgroundColorRes = R.color.stories_surface,
                )
            }
            WordColorSchema.Pink -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_pink,
                    wordTextColorRes = R.color.stories_blackberry,
                    translationTextColorRes = R.color.stories_blackberry,
                    translationBackgroundColorRes = R.color.stories_surface,
                )
            }
            WordColorSchema.Juniper -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_juniper,
                    wordTextColorRes = R.color.stories_surface,
                    translationTextColorRes = R.color.stories_juniper,
                    translationBackgroundColorRes = R.color.stories_surface,
                )
            }
            WordColorSchema.JuniperLight -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_juniper_16,
                    wordTextColorRes = R.color.stories_juniper,
                    translationTextColorRes = R.color.stories_surface,
                    translationBackgroundColorRes = R.color.stories_juniper,
                )
            }
            WordColorSchema.Cyan -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_cyan,
                    wordTextColorRes = R.color.stories_surface,
                    translationTextColorRes = R.color.stories_cyan,
                    translationBackgroundColorRes = R.color.stories_surface,
                )
            }
            WordColorSchema.CyanLight -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_cyan_16,
                    wordTextColorRes = R.color.stories_cyan,
                    translationTextColorRes = R.color.stories_surface,
                    translationBackgroundColorRes = R.color.stories_cyan,
                )
            }
            WordColorSchema.Lime -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_lime,
                    wordTextColorRes = R.color.stories_juniper,
                    translationTextColorRes = R.color.stories_juniper,
                    translationBackgroundColorRes = R.color.stories_surface,
                )
            }
            WordColorSchema.LimeLight -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_lime_16,
                    wordTextColorRes = R.color.stories_juniper,
                    translationTextColorRes = R.color.stories_juniper,
                    translationBackgroundColorRes = R.color.stories_lime,
                )
            }
            WordColorSchema.Raspberry -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_raspberry,
                    wordTextColorRes = R.color.stories_surface,
                    translationTextColorRes = R.color.stories_raspberry,
                    translationBackgroundColorRes = R.color.stories_surface,
                )
            }
            WordColorSchema.RaspberryLight -> {
                WordColorSchemaUiModel(
                    backgroundColorRes = R.color.stories_raspberry_16,
                    wordTextColorRes = R.color.stories_raspberry,
                    translationTextColorRes = R.color.stories_surface,
                    translationBackgroundColorRes = R.color.stories_raspberry,
                )
            }
        }
    }
}