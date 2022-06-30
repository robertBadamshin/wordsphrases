// Generated by Dagger (https://dagger.dev).
package com.app.wordsphrases.translation_impl.di.oxford;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import retrofit2.Retrofit;

@ScopeMetadata("com.app.wordsphrases.core.di.AppScope")
@QualifierMetadata("com.app.wordsphrases.translation_impl.di.oxford.OxfordRetrofitQualifier")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OxfordDictionaryRetrofitModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final OxfordDictionaryRetrofitModule module;

  public OxfordDictionaryRetrofitModule_ProvideRetrofitFactory(
      OxfordDictionaryRetrofitModule module) {
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module);
  }

  public static OxfordDictionaryRetrofitModule_ProvideRetrofitFactory create(
      OxfordDictionaryRetrofitModule module) {
    return new OxfordDictionaryRetrofitModule_ProvideRetrofitFactory(module);
  }

  public static Retrofit provideRetrofit(OxfordDictionaryRetrofitModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit());
  }
}
