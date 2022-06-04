// Generated by Dagger (https://dagger.dev).
package com.app.wordsphrases.home_impl.presentation;

import com.app.wordsphrases.stories_api.StoriesStarter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import ru.terrakok.cicerone.Router;

@ScopeMetadata
@QualifierMetadata("com.app.wordsphrases.home_api.HomeNavigationQualifier")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomePresenter_Factory implements Factory<HomePresenter> {
  private final Provider<StoriesStarter> storiesStarterProvider;

  private final Provider<Router> routerProvider;

  public HomePresenter_Factory(Provider<StoriesStarter> storiesStarterProvider,
      Provider<Router> routerProvider) {
    this.storiesStarterProvider = storiesStarterProvider;
    this.routerProvider = routerProvider;
  }

  @Override
  public HomePresenter get() {
    return newInstance(storiesStarterProvider.get(), routerProvider.get());
  }

  public static HomePresenter_Factory create(Provider<StoriesStarter> storiesStarterProvider,
      Provider<Router> routerProvider) {
    return new HomePresenter_Factory(storiesStarterProvider, routerProvider);
  }

  public static HomePresenter newInstance(StoriesStarter storiesStarter, Router router) {
    return new HomePresenter(storiesStarter, router);
  }
}
