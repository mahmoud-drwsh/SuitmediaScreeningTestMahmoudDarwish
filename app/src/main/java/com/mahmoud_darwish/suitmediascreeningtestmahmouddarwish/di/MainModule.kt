package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.di

import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain.api.Constants
import com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish.data.model.domain.api.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): Service = retrofit.create(Service::class.java)
}