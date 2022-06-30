package com.app.wordsphrases.translation_impl.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0006"}, d2 = {"Lcom/app/wordsphrases/translation_impl/di/TranslationApiBindsModule;", "", "provideTranslateText", "Lcom/app/wordsphrases/translation_api/TranslateText;", "impl", "Lcom/app/wordsphrases/translation_impl/domain/TranslateTextImpl;", "translation-impl_debug"})
@dagger.Module()
public abstract interface TranslationApiBindsModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.app.wordsphrases.translation_api.TranslateText provideTranslateText(@org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.translation_impl.domain.TranslateTextImpl impl);
}