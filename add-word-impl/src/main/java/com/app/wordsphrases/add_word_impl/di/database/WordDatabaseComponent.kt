package com.app.wordsphrases.add_word_impl.di.database

import android.content.Context
import com.app.wordsphrases.add_word_impl.data.datasource.GetWordsDao
import com.app.wordsphrases.add_word_impl.data.datasource.InsertWordDao
import com.app.wordsphrases.add_word_impl.di.WordsDatabaseModule
import dagger.BindsInstance
import dagger.Component

@WordDatabaseScope
@Component(
    modules = [
        WordsDatabaseModule::class,
    ]
)
interface WordDatabaseComponent {

    companion object {

        private var component: WordDatabaseComponent? = null

        fun init(context: Context) {
            return synchronized(this) {
                if (component == null) {
                    component = DaggerWordDatabaseComponent.factory().create(context)
                }
            }
        }

        fun require(): WordDatabaseComponent {
            return component ?: throw IllegalStateException("component must be initialized")
        }
    }

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): WordDatabaseComponent
    }

    val getWordsDao: GetWordsDao

    val insertWordDao: InsertWordDao
}