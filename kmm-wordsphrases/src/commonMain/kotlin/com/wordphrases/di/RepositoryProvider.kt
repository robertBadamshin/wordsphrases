package com.wordphrases.di

import com.wordphrases.data.repository.WordsRepository

object RepositoryProvider {

    val wordsRepository by lazy { WordsRepository() }
}