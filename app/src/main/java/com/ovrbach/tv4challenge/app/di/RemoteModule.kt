package com.ovrbach.tv4challenge.app.di

import com.ovrbach.tv4challenge.data.remote.ErrorHandler
import com.ovrbach.tv4challenge.data.remote.RemoteServiceConstants
import com.ovrbach.tv4challenge.data.remote.service.ShowRemoteService
import com.ovrbach.tv4challenge.data.remote.source.ShowRemoteSourceImpl
import com.ovrbach.tv4challenge.data.show.ShowRemoteSource
import com.ovrbach.tv4challenge.data.show.ShowRepository
import com.ovrbach.tv4challenge.data.show.ShowRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
class RemoteModule {


    @Provides
    fun provideApiClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(RemoteServiceConstants.BASE_API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun provideAlbumService(apiRetrofit: Retrofit): ShowRemoteService =
        apiRetrofit.create(ShowRemoteService::class.java)

    @Provides
    fun provideShowRemoteSource(
        service: ShowRemoteService,
        errorHandler: ErrorHandler
    ): ShowRemoteSource =
        ShowRemoteSourceImpl(
            remoteService = service,
            errorHandler = errorHandler
        )

    @Provides
    fun provideShowRepository(remoteSource: ShowRemoteSource): ShowRepository =
        ShowRepositoryImpl(remoteSource = remoteSource)

}