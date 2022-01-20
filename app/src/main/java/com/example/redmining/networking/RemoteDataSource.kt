package com.example.redmining.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RemoteDataSource {

    companion object{
        private const val BASE_URL = "https://your.server.com"
    }

    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(api)
    }

    private val client: OkHttpClient =  OkHttpClient.Builder()
        .addInterceptor(BasicAuthInterceptor("<username>", "<password>"))
        .build()

}