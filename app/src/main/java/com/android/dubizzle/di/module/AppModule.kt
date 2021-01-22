package com.android.dubizzle.di.module

import com.android.dubizzle.di.qualifier.BaseUrlString
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @BaseUrlString
    fun provideBaseUrl() :String{
        return "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/";
    }

}