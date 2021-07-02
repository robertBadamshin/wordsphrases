package com.app.wordsphrases.core_ui.ui.adapter

import androidx.recyclerview.widget.DiffUtil

open class SimpleDiffUtilCallback<T : DiffItem<T>> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem.isSame(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.isContentSame(newItem)
    }

    override fun getChangePayload(oldItem: T, newItem: T): Any? {
        return oldItem.getChangePayload(newItem)
    }
}