package com.example.hiltimplementation.di

import com.example.hiltimplementation.data.remote.PostAPI
import com.example.hiltimplementation.data.repository.IPostRepository
import com.example.hiltimplementation.data.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePostRepo(apiService: PostAPI): IPostRepository =
        PostRepository(apiService = apiService)
}