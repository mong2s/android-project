package com.example.myapplication.util

import com.example.myapplication.data.gitDataModel
import retrofit2.http.GET
import io.reactivex.Single
import retrofit2.http.Path


interface  gitDataRetrofitInterface {
    @GET("repos/{owner}/{repo}/contributors")
     fun requestContributors(
         @Path("owner") owner:String,
         @Path("repo") repo:String
     ) : Single<Array<gitDataModel>>
}