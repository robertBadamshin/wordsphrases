// Generated by Dagger (https://dagger.dev).
package com.app.wordsphrases.translation_impl.domain;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TranslateTextByMicrosoft_Factory implements Factory<TranslateTextByMicrosoft> {
  @Override
  public TranslateTextByMicrosoft get() {
    return newInstance();
  }

  public static TranslateTextByMicrosoft_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TranslateTextByMicrosoft newInstance() {
    return new TranslateTextByMicrosoft();
  }

  private static final class InstanceHolder {
    private static final TranslateTextByMicrosoft_Factory INSTANCE = new TranslateTextByMicrosoft_Factory();
  }
}