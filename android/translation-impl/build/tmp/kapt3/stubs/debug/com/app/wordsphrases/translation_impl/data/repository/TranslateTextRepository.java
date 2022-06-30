package com.app.wordsphrases.translation_impl.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/app/wordsphrases/translation_impl/data/repository/TranslateTextRepository;", "", "oxfordDictionaryService", "Lcom/app/wordsphrases/translation_impl/data/datasource/service/OxfordDictionaryService;", "(Lcom/app/wordsphrases/translation_impl/data/datasource/service/OxfordDictionaryService;)V", "disabledLexicalId", "Lcom/app/wordsphrases/translation_impl/domain/OxfordGrammaticalFeatureId;", "translateText", "Lcom/app/wordsphrases/translation_api/domain/TranslationResult;", "from", "", "to", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translation-impl_debug"})
public final class TranslateTextRepository {
    private final com.app.wordsphrases.translation_impl.data.datasource.service.OxfordDictionaryService oxfordDictionaryService = null;
    private final com.app.wordsphrases.translation_impl.domain.OxfordGrammaticalFeatureId disabledLexicalId = com.app.wordsphrases.translation_impl.domain.OxfordGrammaticalFeatureId.Imperfective;
    
    @javax.inject.Inject()
    public TranslateTextRepository(@org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.translation_impl.data.datasource.service.OxfordDictionaryService oxfordDictionaryService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object translateText(@org.jetbrains.annotations.NotNull()
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    java.lang.String to, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.app.wordsphrases.translation_api.domain.TranslationResult> continuation) {
        return null;
    }
}