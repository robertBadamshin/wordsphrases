package com.app.wordsphrases.translation_impl.di.oxford

import com.app.wordsphrases.core.di.AppScope
import com.app.wordsphrases.translation_impl.data.datasource.OxfordHeaderInterceptor
import com.app.wordsphrases.translation_impl.data.datasource.service.OxfordDictionaryService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val endpoint = "https://od-api.oxforddictionaries.com/api/v2/translations/"

@Module
class OxfordDictionaryRetrofitModule {

    @Provides
    @AppScope
    @OxfordRetrofitQualifier
    fun provideRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder().addInterceptor(
            OxfordHeaderInterceptor(),
        ).build()

        return Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @AppScope
    fun provideOxfordDictionaryService(@OxfordRetrofitQualifier retrofit: Retrofit): OxfordDictionaryService {
        return retrofit.create(OxfordDictionaryService::class.java)
    }
}