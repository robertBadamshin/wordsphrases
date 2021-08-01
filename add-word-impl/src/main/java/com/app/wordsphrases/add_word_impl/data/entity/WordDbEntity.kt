package com.app.wordsphrases.add_word_impl.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
data class WordDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val translation: String,
    val imageUrl: String?,
    val createdAt: Long,
)