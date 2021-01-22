package com.android.dubizzle.di.module

import android.util.Log
import com.android.dubizzle.data.remote.ApiService
import com.android.dubizzle.di.qualifier.BaseUrlString
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        gSon: Gson,
        @BaseUrlString baseUrlString: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrlString)
            .addConverterFactory(GsonConverterFactory.create(gSon))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggerInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { message ->
            Log.d(
                "Dubizzle : ",
                "log: $message"
            )
        }
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor;
    }

    @Provides
    @Singleton
    fun provideGson() : Gson {
        return GsonBuilder()
            .create()
    }

}