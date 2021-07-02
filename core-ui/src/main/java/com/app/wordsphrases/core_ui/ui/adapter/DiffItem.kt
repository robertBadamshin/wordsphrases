package com.app.wordsphrases.core_ui.ui.adapter

interface DiffItem<T : DiffItem<T>> {

    fun isSame(newItem: T): Boolean = false

    fun isContentSame(newItem: T): Boolean = false

    fun getChangePayload(newItem: T): Any? = Unit
}