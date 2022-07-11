package com.app.wordsphrases.word_detail_api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/app/wordsphrases/word_detail_api/WordDetailStarter;", "", "getScreen", "Lru/terrakok/cicerone/android/support/SupportAppScreen;", "wordId", "", "Lcom/wordphrases/domain/entity/WordId;", "word-detail-api_debug"})
public abstract interface WordDetailStarter {
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.terrakok.cicerone.android.support.SupportAppScreen getScreen(long wordId);
}