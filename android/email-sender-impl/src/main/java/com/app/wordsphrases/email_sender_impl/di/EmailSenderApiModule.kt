package com.app.wordsphrases.email_sender_impl.di

import com.app.wordsphrases.email_sender_api.FeedbackEmailSender
import com.app.wordsphrases.email_sender_impl.domain.FeedbackEmailSenderImpl
import dagger.Binds
import dagger.Module

@Module
interface EmailSenderApiModule {

    @Binds
    fun provideFeedbackEmailSender(impl: FeedbackEmailSenderImpl): FeedbackEmailSender
}