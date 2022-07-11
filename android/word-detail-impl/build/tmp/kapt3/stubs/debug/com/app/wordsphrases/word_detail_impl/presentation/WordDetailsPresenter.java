package com.app.wordsphrases.word_detail_impl.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/app/wordsphrases/word_detail_impl/presentation/WordDetailsPresenter;", "Lmoxy/MvpPresenter;", "Lcom/app/wordsphrases/word_detail_impl/presentation/WordDetailsView;", "router", "Lru/terrakok/cicerone/Router;", "getWordById", "Lcom/wordphrases/domain/usecase/word/GetWordById;", "wordUiMapper", "Lcom/app/wordsphrases/word_detail_impl/presentation/ui/model/mapper/WordUiMapper;", "wordIdHolder", "Lcom/app/wordsphrases/word_detail_impl/domain/entity/WordIdHolder;", "(Lru/terrakok/cicerone/Router;Lcom/wordphrases/domain/usecase/word/GetWordById;Lcom/app/wordsphrases/word_detail_impl/presentation/ui/model/mapper/WordUiMapper;Lcom/app/wordsphrases/word_detail_impl/domain/entity/WordIdHolder;)V", "onBackPressed", "", "onEditWordClick", "onFirstViewAttach", "word-detail-impl_debug"})
public final class WordDetailsPresenter extends moxy.MvpPresenter<com.app.wordsphrases.word_detail_impl.presentation.WordDetailsView> {
    private final ru.terrakok.cicerone.Router router = null;
    private final com.wordphrases.domain.usecase.word.GetWordById getWordById = null;
    private final com.app.wordsphrases.word_detail_impl.presentation.ui.model.mapper.WordUiMapper wordUiMapper = null;
    private final com.app.wordsphrases.word_detail_impl.domain.entity.WordIdHolder wordIdHolder = null;
    
    @javax.inject.Inject()
    public WordDetailsPresenter(@org.jetbrains.annotations.NotNull()
    @com.app.wordsphrases.core.di.MainNavigationQualifier()
    ru.terrakok.cicerone.Router router, @org.jetbrains.annotations.NotNull()
    com.wordphrases.domain.usecase.word.GetWordById getWordById, @org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.word_detail_impl.presentation.ui.model.mapper.WordUiMapper wordUiMapper, @org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.word_detail_impl.domain.entity.WordIdHolder wordIdHolder) {
        super();
    }
    
    @java.lang.Override()
    protected void onFirstViewAttach() {
    }
    
    public final void onBackPressed() {
    }
    
    public final void onEditWordClick() {
    }
}