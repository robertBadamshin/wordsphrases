package com.wordphrases.data.repository

import com.wordphrases.data.repository.datasource.*
import com.wordphrases.db.*
import com.wordphrases.di.DataSourceProvider
import com.wordphrases.domain.entity.*
import kotlinx.coroutines.flow.*

class WordsRepository(
    private val wordLocalDataSource: WordLocalDataSource = DataSourceProvider.wordLocalDataSource,
    private val translationLocalDataSource: TranslationLocalDataSource = DataSourceProvider.translationLocalDataSource,
) {

    fun save(word: Word) {
        wordLocalDataSource.executeWordsInTransaction {
            val dbEntity = mapDbEntity(word)

            wordLocalDataSource.insert(entity = dbEntity)
            val newWordId = wordLocalDataSource.lastInsertedRowId()

            translationLocalDataSource.executeTranslationsInTransaction {

                afterRollback {
                    this@executeWordsInTransaction.rollback()
                }

                insertTranslations(word, newWordId)
            }
        }
    }

    fun update(word: Word) {
        wordLocalDataSource.executeWordsInTransaction {
            val dbEntity = mapDbEntity(word)

            wordLocalDataSource.update(entity = dbEntity)

            translationLocalDataSource.executeTranslationsInTransaction {

                afterRollback {
                    this@executeWordsInTransaction.rollback()
                }

                insertTranslations(word, word.wordId)
            }
        }
    }

    private fun insertTranslations(word: Word, newWordId: Long) {
        word.translations.map { translation ->
            val translationDbEntity = TranslationDbEntity(
                transaltionId = -1,
                wordId = newWordId,
                transaltionText = translation
            )
            translationLocalDataSource.insert(translationDbEntity)
        }
    }

    private fun mapDbEntity(word: Word): WordDbEntity {
        return WordDbEntity(
            wordId = word.wordId,
            languagePairId = word.languagePairId,
            createdAt = word.createdAt,
            wordText = word.wordText,
            sortOrder = word.sortOrder,
            maxRepeatCount = word.maxRepeatCount,
            repeatCount = word.maxRepeatCount,
            synced = 0,
            comment = word.comment,
            colorSchema = word.colorSchema.ordinal.toLong(),
        )
    }

    fun getAllWordsForDictionary(languagePairId: Long): Flow<List<Word>> {
        return wordLocalDataSource.getAllWordsForDictionary(languagePairId)
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

                            val wordColorSchema = getDomainWordColorSchema(word)
                            Word(
                                wordId = word.wordId,
                                languagePairId = word.languagePairId,
                                createdAt = word.createdAt,
                                wordText = word.wordText,
                                sortOrder = word.sortOrder,
                                maxRepeatCount = word.maxRepeatCount,
                                repeatCount = word.repeatCount,
                                translations = translationsDomain,
                                comment = word.comment,
                                colorSchema = wordColorSchema,
                            )
                        }
                    }
            }
    }

    // TODO improve logic
    private fun getDomainWordColorSchema(word: WordDbEntity): WordColorSchema {
        return WordColorSchema.values()[word.colorSchema.toInt()]
    }

    fun getWordById(wordId: WordId): Word {
        val word = wordLocalDataSource.getWordById(wordId)

        val translations = translationLocalDataSource.getTranslationsForWord(wordId)
        val translationsDomain = translations
            .map { translation -> translation.transaltionText }

        val wordColorSchema = getDomainWordColorSchema(word)
        return Word(
            wordId = word.wordId,
            languagePairId = word.languagePairId,
            createdAt = word.createdAt,
            wordText = word.wordText,
            sortOrder = word.sortOrder,
            maxRepeatCount = word.maxRepeatCount,
            repeatCount = word.repeatCount,
            translations = translationsDomain,
            comment = word.comment,
            colorSchema = wordColorSchema,
        )
    }
}