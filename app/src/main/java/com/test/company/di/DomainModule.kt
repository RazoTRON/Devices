package com.test.company.di

import com.test.company.domain.common.AppCoroutineDispatcher
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideDispatchers(): AppCoroutineDispatcher {
        return AppCoroutineDispatcher()
    }
}