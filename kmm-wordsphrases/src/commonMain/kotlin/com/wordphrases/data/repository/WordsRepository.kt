package com.wordphrases.data.repository

import com.wordphrases.data.repository.datasource.*
import com.wordphrases.db.*
import com.wordphrases.di.*
import com.wordphrases.domain.entity.Word
import kotlinx.coroutines.flow.*

class WordsRepository(
    private val wordLocalDataSource: WordLocalDataSource = DataSourceProvider.wordLocalDataSource,
    private val translationLocalDataSource: TranslationLocalDataSource = DataSourceProvider.translationLocalDataSource,
) {

    fun save(word: Word) {
        wordLocalDataSource.executeWordsInTransaction {
            val dbEntity = WordDbEntity(
                wordId = word.wordId,
                createdAt = word.createdAt,
                wordText = word.wordText,
                sortOrder = word.sortOrder,
                maxRepeatCount = word.maxRepeatCount,
                repeatCount = word.maxRepeatCount,
                synced = 0,
            )

            wordLocalDataSource.insert(entity = dbEntity)
            val newWordId = wordLocalDataSource.lastInsertedRowId()

            translationLocalDataSource.executeTranslationsInTransaction {

                afterRollback {
                    this@executeWordsInTransaction.rollback()
                }

                word.translations.map { translation ->
                    val translationDbEntity = TranslationDbEntity(
                        transaltionId = -1,
                        wordId = newWordId,
                        transaltionText = translation
                    )
                    translationLocalDataSource.insert(translationDbEntity)
                }
            }
        }
    }

    fun getWordsForStories(): Flow<List<Word>> {
        return wordLocalDataSource.getWordsForStories()
            .flatMapLatest { words ->
                val wordsIds = words.map { word -> word.wordId }

                translationLocalDataSource.getTranslationsForWords(wordsIds)
                    .map { translations ->
                        val groupedTranslations =
                            translations.groupBy { translation -> translation.wordId }

                        words.map { word ->
                            val translationForWords = groupedTranslations[word.wordId]
                            val translationsDomain = translationForWords
                                ?.map { translation -> translation.transaltionText }
                                .orEmpty()

                            Word(
                                wordId = word.wordId,
                                createdAt = word.createdAt,
                                wordText = word.wordText,
                                sortOrder = word.sortOrder,
                                maxRepeatCount = word.maxRepeatCount,
                                repeatCount = word.repeatCount,
                                translations = translationsDomain,
                            )
                        }
                    }
            }
    }
}