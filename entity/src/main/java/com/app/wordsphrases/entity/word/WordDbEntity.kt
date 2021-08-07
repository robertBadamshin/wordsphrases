package com.app.wordsphrases.entity.word

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

fun WordDbEntity.toDomainEntity(): Word {
    return Word(
        id = id,
        createdAt = createdAt,
        word = word,
        translation = translation,
        imageUrl = imageUrl,
    )
}