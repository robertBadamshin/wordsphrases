package com.app.wordsphrases.edit_word_impl.di

import com.app.wordsphrases.edit_word_api.EditWordStarter
import com.app.wordsphrases.edit_word_impl.navigation.EditWordStarterImpl
import dagger.*

@Module
interface EditWordApiModule {

    @Binds
    fun enterWordStarter(impl: EditWordStarterImpl): EditWordStarter
}