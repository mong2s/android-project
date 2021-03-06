package com.example.myapplication.util

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object weatherOKHttpRestofit {
    val CONNECT_TIMEOUT: Long = 15
    val WRITE_TIMEOUT: Long = 15
    val READ_TIMEOUT: Long = 15
    val API_URL: String = "https://api.openweathermap.org/"

    var mOKHttpClient: OkHttpClient
    var mRetrofit: Retrofit
    var RetrofitInterface: weatherRetrofitInterface

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        mOKHttpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        }.build()


        mRetrofit = Retrofit.Builder().apply {
            baseUrl(API_URL)
            client(mOKHttpClient)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
        }.build()


        RetrofitInterface = mRetrofit.create()
    }

    fun getInstance():weatherRetrofitInterface {
        return RetrofitInterface
    }
}