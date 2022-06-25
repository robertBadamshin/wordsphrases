package com.app.wordsphrases.email_sender_impl.di

import com.app.wordsphrases.email_sender_api.*
import com.app.wordsphrases.email_sender_impl.domain.*
import dagger.*

@Module
interface EmailSenderApiModule {

    @Binds
    fun provideFeedbackEmailSender(impl: FeedbackEmailSenderImpl): FeedbackEmailSender

    @Binds
    fun provideRequestLanguageEmailSender(
        impl: RequestLanguageEmailSenderImpl,
    ): RequestLanguageEmailSender
}