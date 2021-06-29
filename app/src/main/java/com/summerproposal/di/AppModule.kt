package com.summerproposal.di

import android.content.Context
import com.summerproposal.PeacockExampleApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app : Context): PeacockExampleApplication {
        return app as PeacockExampleApplication
    }


    @Singleton
    @Provides
    @Named("test_string")
    fun provideRandomString() : String {
        return "Random string being injected!!"
    }

}