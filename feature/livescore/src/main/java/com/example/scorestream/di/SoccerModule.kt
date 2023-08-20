package com.example.scorestream.di

import com.example.scorestream.data.remote.api.SoccerApi
import com.example.scorestream.data.repository.MatchRepositoryImpl
import com.example.scorestream.domain.repository.MatchRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SoccerModule {

    companion object {
        @Provides
        @Singleton
        fun provideSoccerApi(retrofit: Retrofit): SoccerApi {
            return retrofit.create(SoccerApi::class.java)
        }
    }

    @Singleton
    @Binds
    fun bindMatchRepository(impl: MatchRepositoryImpl): MatchRepository

}