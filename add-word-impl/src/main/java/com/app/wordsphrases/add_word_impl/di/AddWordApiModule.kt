package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.GetWords
import com.app.wordsphrases.add_word_api.SelectTranslationStarter
import com.app.wordsphrases.add_word_api.domain.CreateAddWordComponent
import com.app.wordsphrases.add_word_api.domain.CreatePopupAddWordComponent
import com.app.wordsphrases.add_word_api.domain.RequireAddWordComponent
import com.app.wordsphrases.add_word_api.domain.RequirePopupAddWordComponent
import com.app.wordsphrases.add_word_impl.domain.CreateAddWordComponentImpl
import com.app.wordsphrases.add_word_impl.domain.CreatePopupAddWordComponentImpl
import com.app.wordsphrases.add_word_impl.domain.GetWordsImpl
import com.app.wordsphrases.add_word_impl.domain.RequireAddWordComponentImpl
import com.app.wordsphrases.add_word_impl.domain.RequirePopupAddWordComponentImpl
import com.app.wordsphrases.add_word_impl.navigation.EnterWordStarterImpl
import com.app.wordsphrases.add_word_impl.navigation.SelectTranslationStarterImpl
import com.app.wordsphrases.core.di.AppScope
import dagger.Binds
import dagger.Module

@Module
interface AddWordApiModule {

    @Binds
    fun enterWordStarter(impl: EnterWordStarterImpl): EnterWordStarter

    @Binds
    fun selectTranslationStarter(impl: SelectTranslationStarterImpl): SelectTranslationStarter

    @Binds
    @AppScope
    fun getWords(impl: GetWordsImpl): GetWords

    @Binds
    fun createPopupAddWordComponent(impl: CreatePopupAddWordComponentImpl): CreatePopupAddWordComponent

    @Binds
    fun requireAddWordComponent(impl: RequireAddWordComponentImpl): RequireAddWordComponent

    @Binds
    fun createAddWordComponent(impl: CreateAddWordComponentImpl): CreateAddWordComponent

    @Binds
    fun requirePopupAddWordComponent(impl: RequirePopupAddWordComponentImpl): RequirePopupAddWordComponent
}