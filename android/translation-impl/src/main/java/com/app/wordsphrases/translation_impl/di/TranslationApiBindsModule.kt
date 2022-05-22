package com.app.wordsphrases.translation_impl.di

import com.app.wordsphrases.translation_api.TranslateText
import com.app.wordsphrases.translation_impl.domain.TranslateTextImpl
import dagger.*

@Module
interface TranslationApiBindsModule {

    @Binds
    fun provideTranslateText(impl: TranslateTextImpl): TranslateText
}