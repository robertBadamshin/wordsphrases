package com.wordphrases.di

import com.wordphrases.data.repository.*

object RepositoryProvider {

    val wordsRepository by lazy { WordsRepository() }

    val authRepository by lazy { AuthRepository() }
}