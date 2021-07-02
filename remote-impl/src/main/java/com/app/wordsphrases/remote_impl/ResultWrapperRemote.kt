package com.app.wordsphrases.remote_impl

import com.google.gson.annotations.SerializedName

data class ResultWrapperRemote<T>(
    @SerializedName("Success:")
    val result: T,
    @SerializedName("Error:")
    val error: String,
)