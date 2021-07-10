package com.app.wordsphrases.add_word_impl.di

import com.app.wordsphrases.add_word_impl.data.service.AddWordService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AddWordModule {

    @Provides
    fun provideAddWordService(retrofit: Retrofit): AddWordService {
        return retrofit.create(AddWordService::class.java)
    }
}