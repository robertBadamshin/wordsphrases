package com.app.wordsphrases.remote_impl.converter

import com.wordphrases.ResultWrapper
import com.app.wordsphrases.remote_impl.ResultWrapperRemote
import com.app.wordsphrases.remote_impl.exception.ServerException
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


class ResultWrapperResponseGsonConverter : Converter.Factory() {

    // TODO make inject
    private val gson = Gson()

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        val parametrizedType = (type as ParameterizedType).actualTypeArguments.first()
        val resultWrapperRemoteType = object : ParameterizedType {
            override fun getActualTypeArguments(): Array<Type> = arrayOf(parametrizedType)
            override fun getOwnerType(): Type? = null
            override fun getRawType(): Type = ResultWrapperRemote::class.java
        }

        return ResponseBodyConverter<ResultWrapperRemote<Any>>(
            type = resultWrapperRemoteType,
            gson = gson,
        )
    }

    private class ResponseBodyConverter<T>(
        private val type: Type,
        private val gson: Gson,
    ) : Converter<ResponseBody, ResultWrapper<T>> {

        @Throws(IOException::class)
        override fun convert(responseBody: ResponseBody): ResultWrapper<T> {
            val responseBodyString = responseBody.string()
            val responseString = responseBodyString.removePrefix("Success: ")
            val response = gson.fromJson<ResultWrapperRemote<T>>(
                responseString,
                type,
            )

            return if (response?.result != null) {
                ResultWrapper(data = response.result)
            } else {
                ResultWrapper(exception = ServerException(response!!.error))
            }
        }
    }
}