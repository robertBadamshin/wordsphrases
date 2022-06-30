package com.app.wordsphrases.translation_impl.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/app/wordsphrases/translation_impl/domain/TranslateTextByOxfordDictionary;", "", "translateTextRepository", "Lcom/app/wordsphrases/translation_impl/data/repository/TranslateTextRepository;", "(Lcom/app/wordsphrases/translation_impl/data/repository/TranslateTextRepository;)V", "client", "Lokhttp3/OkHttpClient;", "gson", "Lcom/google/gson/Gson;", "invoke", "Lcom/app/wordsphrases/translation_api/domain/TranslationResult;", "text", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translation-impl_debug"})
public final class TranslateTextByOxfordDictionary {
    private final com.app.wordsphrases.translation_impl.data.repository.TranslateTextRepository translateTextRepository = null;
    private final okhttp3.OkHttpClient client = null;
    private final com.google.gson.Gson gson = null;
    
    @javax.inject.Inject()
    public TranslateTextByOxfordDictionary(@org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.translation_impl.data.repository.TranslateTextRepository translateTextRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.app.wordsphrases.translation_api.domain.TranslationResult> continuation) {
        return null;
    }
}