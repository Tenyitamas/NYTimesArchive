package com.android.tenyitamas.nytimesarchive.di

import com.android.tenyitamas.nytimesarchive.data.remote.ArchiveApi
import com.android.tenyitamas.nytimesarchive.data.repository.ArchiveRepositoryImpl
import com.android.tenyitamas.nytimesarchive.domain.repository.ArchiveRepository
import com.android.tenyitamas.nytimesarchive.domain.use_case.GetArchives
import com.android.tenyitamas.nytimesarchive.util.ApiConstants.Companion.ARCHIVE_API_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideArchiveApi(client: OkHttpClient): ArchiveApi {
        return Retrofit.Builder()
            .baseUrl(ARCHIVE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideArchiveRepository(api: ArchiveApi): ArchiveRepository = ArchiveRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetArchivesUseCase(repository: ArchiveRepository) = GetArchives(repository)
}