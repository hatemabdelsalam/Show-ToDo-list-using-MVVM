package com.hatem.todolist.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val AUTH_NAME = ""
    private const val AUTH_VALUE = ""


    private val okHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val originalRequest = chain.request()

        val requestBuilder =
            originalRequest.newBuilder().method(originalRequest.method(), originalRequest.body())
                .build()

        chain.proceed(requestBuilder)
    }.build()


    val instant: APIs by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Urls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
        retrofit.create(APIs::class.java)
    }
}