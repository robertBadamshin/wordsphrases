package com.app.wordsphrases.word_detail_impl.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/app/wordsphrases/word_detail_impl/presentation/WordDetailsView;", "Lmoxy/MvpView;", "showWord", "", "uiModel", "Lcom/app/wordsphrases/word_detail_impl/presentation/ui/model/WordUiModel;", "word-detail-impl_debug"})
@moxy.viewstate.strategy.alias.AddToEndSingle()
public abstract interface WordDetailsView extends moxy.MvpView {
    
    public abstract void showWord(@org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.word_detail_impl.presentation.ui.model.WordUiModel uiModel);
}