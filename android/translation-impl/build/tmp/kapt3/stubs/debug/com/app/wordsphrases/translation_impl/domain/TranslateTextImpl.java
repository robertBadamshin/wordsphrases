package com.app.wordsphrases.translation_impl.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/app/wordsphrases/translation_impl/domain/TranslateTextImpl;", "Lcom/app/wordsphrases/translation_api/TranslateText;", "translateTextByOxfordDictionary", "Lcom/app/wordsphrases/translation_impl/domain/TranslateTextByOxfordDictionary;", "translateTextByMicrosoft", "Lcom/app/wordsphrases/translation_impl/domain/TranslateTextByMicrosoft;", "countWordsInText", "Lcom/app/wordsphrases/translation_impl/domain/CountWordsInText;", "(Lcom/app/wordsphrases/translation_impl/domain/TranslateTextByOxfordDictionary;Lcom/app/wordsphrases/translation_impl/domain/TranslateTextByMicrosoft;Lcom/app/wordsphrases/translation_impl/domain/CountWordsInText;)V", "formatTranslations", "Lcom/app/wordsphrases/translation_api/domain/TranslationResult;", "result", "invoke", "Lcom/wordphrases/ResultWrapper;", "text", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translation-impl_debug"})
public final class TranslateTextImpl implements com.app.wordsphrases.translation_api.TranslateText {
    private final com.app.wordsphrases.translation_impl.domain.TranslateTextByOxfordDictionary translateTextByOxfordDictionary = null;
    private final com.app.wordsphrases.translation_impl.domain.TranslateTextByMicrosoft translateTextByMicrosoft = null;
    private final com.app.wordsphrases.translation_impl.domain.CountWordsInText countWordsInText = null;
    
    @javax.inject.Inject()
    public TranslateTextImpl(@org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.translation_impl.domain.TranslateTextByOxfordDictionary translateTextByOxfordDictionary, @org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.translation_impl.domain.TranslateTextByMicrosoft translateTextByMicrosoft, @org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.translation_impl.domain.CountWordsInText countWordsInText) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.wordphrases.ResultWrapper<com.app.wordsphrases.translation_api.domain.TranslationResult>> continuation) {
        return null;
    }
    
    private final com.app.wordsphrases.translation_api.domain.TranslationResult formatTranslations(com.app.wordsphrases.translation_api.domain.TranslationResult result) {
        return null;
    }
}