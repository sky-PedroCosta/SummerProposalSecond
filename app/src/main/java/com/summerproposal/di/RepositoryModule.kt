package com.summerproposal.di

import com.summerproposal.repository.PeacockDataRepository
import com.summerproposal.repository.PeacockRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providePeacockRepository(impl: PeacockRepositoryImpl): PeacockDataRepository
}