// Generated by Dagger (https://dagger.dev).
package com.app.wordsphrases.translation_impl.data.repository;

import com.app.wordsphrases.translation_impl.data.datasource.service.OxfordDictionaryService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TranslateTextRepository_Factory implements Factory<TranslateTextRepository> {
  private final Provider<OxfordDictionaryService> oxfordDictionaryServiceProvider;

  public TranslateTextRepository_Factory(
      Provider<OxfordDictionaryService> oxfordDictionaryServiceProvider) {
    this.oxfordDictionaryServiceProvider = oxfordDictionaryServiceProvider;
  }

  @Override
  public TranslateTextRepository get() {
    return newInstance(oxfordDictionaryServiceProvider.get());
  }

  public static TranslateTextRepository_Factory create(
      Provider<OxfordDictionaryService> oxfordDictionaryServiceProvider) {
    return new TranslateTextRepository_Factory(oxfordDictionaryServiceProvider);
  }

  public static TranslateTextRepository newInstance(
      OxfordDictionaryService oxfordDictionaryService) {
    return new TranslateTextRepository(oxfordDictionaryService);
  }
}
