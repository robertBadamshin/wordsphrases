package com.app.wordsphrases.remote_impl

import com.google.gson.annotations.SerializedName

data class ResultWrapperRemote<T>(
    @SerializedName("result")
    val result: T,
    @SerializedName("error")
    val error: String,
    @SerializedName("code")
    val code: Int,
)