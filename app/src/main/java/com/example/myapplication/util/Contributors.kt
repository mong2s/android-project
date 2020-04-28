package com.example.myapplication.util

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Contributors {
    @SerializedName("Host")
    @Expose
    private var Host: String? = null

    @SerializedName("Referer")
    @Expose
    private var Referer: String? = null


    fun getHost(): String? {
       return Host
    }

    fun setHost(login: String) {
        this.Host = Host
    }

    fun getReferer(): String? {
        return Referer
    }

    fun setReferer(login: String) {
        this.Referer = Referer
    }

}