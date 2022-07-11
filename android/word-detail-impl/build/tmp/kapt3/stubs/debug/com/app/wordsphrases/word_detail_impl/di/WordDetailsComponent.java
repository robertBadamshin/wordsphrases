package com.app.wordsphrases.word_detail_impl.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/app/wordsphrases/word_detail_impl/di/WordDetailsComponent;", "", "wordDetailsPresenter", "Lcom/app/wordsphrases/word_detail_impl/presentation/WordDetailsPresenter;", "getWordDetailsPresenter", "()Lcom/app/wordsphrases/word_detail_impl/presentation/WordDetailsPresenter;", "Companion", "Factory", "word-detail-impl_debug"})
@dagger.Component(modules = {com.app.wordsphrases.word_detail_impl.di.WordDetailsProvidesModule.class}, dependencies = {com.app.wordsphrases.core.AppComponent.class})
@com.app.wordsphrases.core.di.FeatureScope()
public abstract interface WordDetailsComponent {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.wordsphrases.word_detail_impl.di.WordDetailsComponent.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.app.wordsphrases.word_detail_impl.presentation.WordDetailsPresenter getWordDetailsPresenter();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/app/wordsphrases/word_detail_impl/di/WordDetailsComponent$Factory;", "", "create", "Lcom/app/wordsphrases/word_detail_impl/di/WordDetailsComponent;", "appComponent", "Lcom/app/wordsphrases/core/AppComponent;", "wordIdHolder", "Lcom/app/wordsphrases/word_detail_impl/domain/entity/WordIdHolder;", "word-detail-impl_debug"})
    @dagger.Component.Factory()
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.app.wordsphrases.word_detail_impl.di.WordDetailsComponent create(@org.jetbrains.annotations.NotNull()
        com.app.wordsphrases.core.AppComponent appComponent, @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        com.app.wordsphrases.word_detail_impl.domain.entity.WordIdHolder wordIdHolder);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/app/wordsphrases/word_detail_impl/di/WordDetailsComponent$Companion;", "", "()V", "get", "Lcom/app/wordsphrases/word_detail_impl/di/WordDetailsComponent;", "wordIdHolder", "Lcom/app/wordsphrases/word_detail_impl/domain/entity/WordIdHolder;", "word-detail-impl_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.wordsphrases.word_detail_impl.di.WordDetailsComponent get(@org.jetbrains.annotations.NotNull()
        com.app.wordsphrases.word_detail_impl.domain.entity.WordIdHolder wordIdHolder) {
            return null;
        }
    }
}