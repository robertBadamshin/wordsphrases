package com.app.wordsphrases.remote_impl

import com.app.wordsphrases.remote_impl.converter.ResultWrapperResponseGsonConverter
import retrofit2.Retrofit

object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
               // .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ResultWrapperResponseGsonConverter())
                .build()
        }
        return retrofit!!
    }
}