package com.app.wordsphrases.translation_impl.di

import com.app.wordsphrases.translation_impl.data.service.TranslationService
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TranslationApiModule {

    @Provides
    fun provideTranslationService(retrofit: Retrofit): TranslationService {
        return retrofit.create(TranslationService::class.java)
    }
}