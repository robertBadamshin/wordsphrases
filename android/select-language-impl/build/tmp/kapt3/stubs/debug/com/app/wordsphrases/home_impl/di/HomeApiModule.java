package com.app.wordsphrases.home_impl.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\t2\u000e\b\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00052\u000e\b\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/app/wordsphrases/select_language_impl/di/HomeApiModule;", "", "()V", "cicerone", "Lru/terrakok/cicerone/Cicerone;", "Lru/terrakok/cicerone/Router;", "homeRouter", "Lcom/app/wordsphrases/home_api/HomeRouter;", "navigationHolder", "Lru/terrakok/cicerone/NavigatorHolder;", "router", "home-impl_debug"})
@dagger.Module()
public final class HomeApiModule {
    
    public HomeApiModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.app.wordsphrases.home_api.HomeRouter homeRouter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.app.wordsphrases.home_api.HomeNavigationQualifier()
    @com.app.wordsphrases.core.di.AppScope()
    @dagger.Provides()
    public final ru.terrakok.cicerone.Cicerone<ru.terrakok.cicerone.Router> cicerone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.app.wordsphrases.home_api.HomeNavigationQualifier()
    @dagger.Provides()
    public final ru.terrakok.cicerone.Router router(@org.jetbrains.annotations.NotNull()
    @com.app.wordsphrases.home_api.HomeNavigationQualifier()
    ru.terrakok.cicerone.Cicerone<ru.terrakok.cicerone.Router> cicerone) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.app.wordsphrases.home_api.HomeNavigationQualifier()
    @dagger.Provides()
    public final ru.terrakok.cicerone.NavigatorHolder navigationHolder(@org.jetbrains.annotations.NotNull()
    @com.app.wordsphrases.home_api.HomeNavigationQualifier()
    ru.terrakok.cicerone.Cicerone<ru.terrakok.cicerone.Router> cicerone) {
        return null;
    }
}