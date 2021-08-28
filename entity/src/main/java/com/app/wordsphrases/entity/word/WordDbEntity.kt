package com.app.wordsphrases.entity.word

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.app.wordsphrases.entity.converter.StringListConverter

@Entity(tableName = "word")
@TypeConverters(
    value = [
        StringListConverter::class
    ],
)
data class WordDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val translations: List<String>,
    val imageUrl: String?,
    val createdAt: Long,
)

fun WordDbEntity.toDomainEntity(): Word {
    return Word(
        id = id,
        createdAt = createdAt,
        word = word,
        translations = translations,
        imageUrl = imageUrl,
    )
}