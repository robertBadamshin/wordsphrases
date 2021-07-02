package com.app.wordsphrases.home_impl.di

import com.app.wordsphrases.home_api.HomeRouter
import com.app.wordsphrases.home_impl.navigation.HomeRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface HomeApiModule {

    @Binds
    fun bind(impl: HomeRouterImpl): HomeRouter
}