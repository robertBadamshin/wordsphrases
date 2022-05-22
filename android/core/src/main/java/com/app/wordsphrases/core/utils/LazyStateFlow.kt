package com.app.wordsphrases.core.utils

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class LazyStateFlow<T> : SharedFlow<T> {

    private val mutableSharedFlow = MutableSharedFlow<T>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    override val replayCache: List<T> = mutableSharedFlow.replayCache

    private var _value: T? = null

    var value: T
        get() {
            return _value ?: throw IllegalStateException("Lazy state flow is not initialized yet")
        }
        set(value) {
            _value = value
            mutableSharedFlow.tryEmit(value)
        }

    //@InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        val sharedFlow  = mutableSharedFlow
            .distinctUntilChanged() as SharedFlow<T>

        sharedFlow.collect(collector)
    }

    public fun resetReplayCache() {
        mutableSharedFlow.resetReplayCache()
    }
}