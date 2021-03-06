package com.ovrbach.tv4challenge.app.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class UtilModule {

    @Provides
    @Singleton
    fun provideResources(@ApplicationContext context: Context): Resources = context.resources
}