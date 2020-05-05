package com.lingdtkhe.data.common

import com.google.gson.Gson
import com.lingdtkhe.data.source.network.api.BASE_URL
import com.lingdtkhe.data.source.network.api.NousDigitalApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Provide NousDigitalApi
 */
object Network {

    fun provideNousDigitalApi(): NousDigitalApi = createApiService(
        okHttpClient(httpLoggingInterceptor()),
        converterFactory(gson())
    )

    private fun createApiService(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): NousDigitalApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory).build()
            .create(NousDigitalApi::class.java)

    private fun okHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private fun httpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        HttpLoggingInterceptor.Level.BODY
    }

    private fun converterFactory(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    private fun gson() = Gson()
}