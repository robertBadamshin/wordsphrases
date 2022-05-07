package com.app.wordsphrases.entity

sealed class RequestStateWrapper<T>

data class RequestSuccessStateWrapper<T>(
    val data: T,
    val rawResponse: String = ""
) : RequestStateWrapper<T>()

data class RequestErrorStateWrapper<T>(
    val throwable: Throwable,
    val rawResponse: String = ""
) : RequestStateWrapper<T>()

class RequestLoadingStateWrapper<T> : RequestStateWrapper<T>() {

    override fun equals(other: Any?): Boolean {
        return javaClass == other?.javaClass
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}

suspend fun <T, R> RequestStateWrapper<T>.mapData(block: suspend (T) -> R): RequestStateWrapper<R> {
    return when (this) {
        is RequestSuccessStateWrapper -> RequestSuccessStateWrapper(
            data = block(data),
            rawResponse = rawResponse
        )
        is RequestErrorStateWrapper -> RequestErrorStateWrapper(
            throwable = throwable,
            rawResponse = rawResponse
        )
        is RequestLoadingStateWrapper -> RequestLoadingStateWrapper()
    }
}