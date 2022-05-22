package com.wordphrases.di

import com.wordphrases.data.repository.datasource.*

object DataSourceProvider {

    val folderLocalDataSource by lazy { FolderLocalDataSource() }

    val folderToFolderLocalDataSource by lazy { FolderToFolderLocalDataSource() }

    val translationLocalDataSource by lazy { TranslationLocalDataSource() }

    val wordLocalDataSource by lazy { WordLocalDataSource() }

    val wordToFolderLocalDataSource by lazy { WordToFolderLocalDataSource() }

    val authDataSource by lazy { AuthDataSource() }

    val authLocalDataSource by lazy { AuthLocalDataSource() }


}