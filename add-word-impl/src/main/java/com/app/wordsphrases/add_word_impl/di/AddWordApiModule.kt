package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.GetWords
import com.app.wordsphrases.add_word_api.SelectTranslationStarter
import com.app.wordsphrases.add_word_impl.domain.GetWordsImpl
import com.app.wordsphrases.add_word_impl.navigation.EnterWordStarterImpl
import com.app.wordsphrases.add_word_impl.navigation.SelectTranslationStarterImpl
import com.app.wordsphrases.core.di.AppScope
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        WordsDatabaseModule::class,
    ]
)
interface AddWordApiModule {

    @Binds
    fun enterWordStarter(impl: EnterWordStarterImpl): EnterWordStarter

    @Binds
    fun selectTranslationStarter(impl: SelectTranslationStarterImpl): SelectTranslationStarter

    @Binds
    @AppScope
    fun getWords(impl: GetWordsImpl): GetWords
}