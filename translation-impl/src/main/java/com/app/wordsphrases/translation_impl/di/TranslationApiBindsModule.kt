package com.app.wordsphrases.translation_impl.di

import com.app.wordsphrases.translation_api.TranslateText
import com.app.wordsphrases.translation_impl.domain.TranslateTextImpl
import dagger.Binds
import dagger.Module

@Module
interface TranslationApiBindsModule {

    @Binds
    fun provideGetTranslation(impl: TranslateTextImpl): TranslateText
}