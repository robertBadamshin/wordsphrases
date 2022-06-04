package com.app.wordsphrases.home_impl.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/app/wordsphrases/select_language_impl/presentation/HomePresenter;", "Lmoxy/MvpPresenter;", "Lcom/app/wordsphrases/select_language_impl/presentation/HomeView;", "storiesStarter", "Lcom/app/wordsphrases/stories_api/StoriesStarter;", "router", "Lru/terrakok/cicerone/Router;", "(Lcom/app/wordsphrases/stories_api/StoriesStarter;Lru/terrakok/cicerone/Router;)V", "onFirstViewAttach", "", "home-impl_debug"})
public final class HomePresenter extends moxy.MvpPresenter<com.app.wordsphrases.home_impl.presentation.HomeView> {
    private final com.app.wordsphrases.stories_api.StoriesStarter storiesStarter = null;
    private final ru.terrakok.cicerone.Router router = null;
    
    @javax.inject.Inject()
    public HomePresenter(@org.jetbrains.annotations.NotNull()
    com.app.wordsphrases.stories_api.StoriesStarter storiesStarter, @org.jetbrains.annotations.NotNull()
    @com.app.wordsphrases.home_api.HomeNavigationQualifier()
    ru.terrakok.cicerone.Router router) {
        super();
    }
    
    @java.lang.Override()
    protected void onFirstViewAttach() {
    }
}