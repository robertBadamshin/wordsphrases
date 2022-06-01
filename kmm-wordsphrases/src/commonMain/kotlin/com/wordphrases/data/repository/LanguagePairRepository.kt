package com.wordphrases.data.repository

import com.wordphrases.data.repository.datasource.*
import com.wordphrases.db.*
import com.wordphrases.di.DataSourceProvider
import com.wordphrases.domain.entity.*
import kotlinx.coroutines.flow.*

class LanguagePairRepository(
    private val languagePairLocalDataSource: LanguagePairLocalDataSource = DataSourceProvider.languagePairLocalDataSource,
) {

    fun save(languagePair: LanguagePair) {
        val selectedDbValue = if (languagePair.selected) {
            1L
        } else {
            0L
        }

        val languagePairDbEntity = LanguagePairDbEntity(
            pairId = languagePair.pairId,
            learningLanguageCode = languagePair.learningLanguageCode,
            nativeLanguageCode = languagePair.nativeLanguageCode,
            selected = selectedDbValue,
        )

        languagePairLocalDataSource.insert(entity = languagePairDbEntity)
    }

    fun getCurrentSelectedLanguagePair(): LanguagePair? {
        return languagePairLocalDataSource.getCurrentSelectedEntity()
            ?.toDomainEntity()
    }

    fun getSelectedLanguagePair(): Flow<LanguagePair> {
        return languagePairLocalDataSource.getSelectedEntity()
            .map { dbEntity -> dbEntity.toDomainEntity() }
    }

    fun requireSelectedLanguagePair(): LanguagePair {
        val selectedPairDbEntity = languagePairLocalDataSource.requireSelectedEntity()
        return selectedPairDbEntity.toDomainEntity()
    }
}

private fun LanguagePairDbEntity.toDomainEntity(): LanguagePair {
    val selectedDomain = selected == 1L

    return LanguagePair(
        pairId = pairId,
        learningLanguageCode = learningLanguageCode,
        nativeLanguageCode = nativeLanguageCode,
        selected = selectedDomain,
    )
}