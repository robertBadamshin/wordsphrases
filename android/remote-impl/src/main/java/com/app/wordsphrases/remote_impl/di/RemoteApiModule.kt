package com.app.wordsphrases.remote_impl.di

import com.app.wordsphrases.remote_impl.RetrofitClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RemoteApiModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return RetrofitClient.getClient("http://wordsandphrases.botast.com/")
    }
}