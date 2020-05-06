package com.example.myapplication.util

import com.example.myapplication.data.weatherDataModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface weatherRetrofitInterface {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") app_id: String
    ): Single<weatherDataModel>
}