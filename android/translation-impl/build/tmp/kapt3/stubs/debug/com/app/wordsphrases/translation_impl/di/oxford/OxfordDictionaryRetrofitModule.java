package com.app.wordsphrases.translation_impl.di.oxford;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/app/wordsphrases/translation_impl/di/oxford/OxfordDictionaryRetrofitModule;", "", "()V", "provideOxfordDictionaryService", "Lcom/app/wordsphrases/translation_impl/data/datasource/service/OxfordDictionaryService;", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofit", "translation-impl_debug"})
@dagger.Module()
public final class OxfordDictionaryRetrofitModule {
    
    public OxfordDictionaryRetrofitModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @OxfordRetrofitQualifier()
    @com.app.wordsphrases.core.di.AppScope()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.app.wordsphrases.core.di.AppScope()
    @dagger.Provides()
    public final com.app.wordsphrases.translation_impl.data.datasource.service.OxfordDictionaryService provideOxfordDictionaryService(@org.jetbrains.annotations.NotNull()
    @OxfordRetrofitQualifier()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}