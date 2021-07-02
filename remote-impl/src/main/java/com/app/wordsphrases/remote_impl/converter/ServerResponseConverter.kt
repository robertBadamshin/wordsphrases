package com.app.wordsphrases.remote_impl.converter

import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.remote_impl.ResultWrapperRemote
import com.app.wordsphrases.remote_impl.exception.ServerException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okhttp3.internal.http.RealResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


class ServerResponseConverter : Converter.Factory() {

    // TODO make inejct
    private val gson = Gson()

    private val gsonConverterFactory = GsonConverterFactory.create(gson)

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val wrappedType = object : ParameterizedType {
            override fun getActualTypeArguments(): Array<Type> = arrayOf(type)
            override fun getOwnerType(): Type? = null
            override fun getRawType(): Type = ResultWrapperRemote::class.java
        }
        val gsonConverter = gsonConverterFactory.responseBodyConverter(
            wrappedType,
            annotations,
            retrofit,
        )
        return ResponseBodyConverter(gsonConverter as Converter<ResponseBody, ResultWrapperRemote<Any>>)
    }

    override fun requestBodyConverter(
        type: Type?,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        return gsonConverterFactory.requestBodyConverter(
            type!!,
            parameterAnnotations,
            methodAnnotations,
            retrofit
        )
    }
}


class ResponseBodyConverter<T>(private val converter: Converter<ResponseBody, ResultWrapperRemote<T>>) :
    Converter<ResponseBody, ResultWrapper<T>> {

    @Throws(IOException::class)
    override fun convert(responseBody: ResponseBody): ResultWrapper<T> {
        val responseBodyString = responseBody.string()
        val responseString = responseBodyString.removePrefix("Success: ")
        val type = object : TypeToken<ResultWrapperRemote<T>>() {}.type
        val response = Gson().fromJson<ResultWrapperRemote<T>>(
            responseString,
            type,
        )
        //   val response = converter.convert(responseString)
        return if (response?.result != null) {
            ResultWrapper(data = response.result)
        } else {
            ResultWrapper(exception = ServerException(response!!.error))
        }
    }
}