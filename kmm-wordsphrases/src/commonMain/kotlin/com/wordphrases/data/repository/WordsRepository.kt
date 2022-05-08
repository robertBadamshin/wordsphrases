package com.wordphrases.data.repository

import com.wordphrases.db.*
import com.wordphrases.di.*
import com.wordphrases.domain.entity.Word

class WordsRepository(
    private val wordLocalDataSource: WordLocalDataSource = DataSourceProvider.wordLocalDataSource,
    private val translationLocalDataSource: TranslationLocalDataSource = DataSourceProvider.translationLocalDataSource,
    private val wordToFolderLocalDataSource: WordToFolderLocalDataSource = DataSourceProvider.wordToFolderLocalDataSource,
) {

    fun putWord(word: Word) {
        val dbEntity = WordDbEntity(
            wordId = word.wordId,
            createdAt = word.createdAt,
            wordText = word.wordText,
            sortOrder = word.sortOrder,
            maxRepeatCount = word.maxRepeatCount,
            repeatCount = word.maxRepeatCount,
        )

        wordLocalDataSource.insert(entity = dbEntity)
    }

//    fun getWords(): List<Word> {
//        return database.wordTableQueries.selectAll().executeAsList()
//    }
}