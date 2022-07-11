// Generated by Dagger (https://dagger.dev).
package com.app.wordsphrases.word_detail_impl.presentation;

import com.app.wordsphrases.word_detail_impl.domain.entity.WordIdHolder;
import com.app.wordsphrases.word_detail_impl.presentation.ui.model.mapper.WordUiMapper;
import com.wordphrases.domain.usecase.word.GetWordById;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import ru.terrakok.cicerone.Router;

@ScopeMetadata
@QualifierMetadata("com.app.wordsphrases.core.di.MainNavigationQualifier")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class WordDetailsPresenter_Factory implements Factory<WordDetailsPresenter> {
  private final Provider<Router> routerProvider;

  private final Provider<GetWordById> getWordByIdProvider;

  private final Provider<WordUiMapper> wordUiMapperProvider;

  private final Provider<WordIdHolder> wordIdHolderProvider;

  public WordDetailsPresenter_Factory(Provider<Router> routerProvider,
      Provider<GetWordById> getWordByIdProvider, Provider<WordUiMapper> wordUiMapperProvider,
      Provider<WordIdHolder> wordIdHolderProvider) {
    this.routerProvider = routerProvider;
    this.getWordByIdProvider = getWordByIdProvider;
    this.wordUiMapperProvider = wordUiMapperProvider;
    this.wordIdHolderProvider = wordIdHolderProvider;
  }

  @Override
  public WordDetailsPresenter get() {
    return newInstance(routerProvider.get(), getWordByIdProvider.get(), wordUiMapperProvider.get(), wordIdHolderProvider.get());
  }

  public static WordDetailsPresenter_Factory create(Provider<Router> routerProvider,
      Provider<GetWordById> getWordByIdProvider, Provider<WordUiMapper> wordUiMapperProvider,
      Provider<WordIdHolder> wordIdHolderProvider) {
    return new WordDetailsPresenter_Factory(routerProvider, getWordByIdProvider, wordUiMapperProvider, wordIdHolderProvider);
  }

  public static WordDetailsPresenter newInstance(Router router, GetWordById getWordById,
      WordUiMapper wordUiMapper, WordIdHolder wordIdHolder) {
    return new WordDetailsPresenter(router, getWordById, wordUiMapper, wordIdHolder);
  }
}
