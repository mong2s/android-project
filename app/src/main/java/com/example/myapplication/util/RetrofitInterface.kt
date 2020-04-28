package com.example.myapplication.util

import retrofit2.http.GET
import io.reactivex.Single
import retrofit2.http.Path


interface  RetrofitInterface {
    @GET("repos/{owner}/{repo}/contributors")
     fun requestContributors(
         @Path("owner") owner:String,
         @Path("repo") repo:String
     ) : Single<Array<Contributors>>
}