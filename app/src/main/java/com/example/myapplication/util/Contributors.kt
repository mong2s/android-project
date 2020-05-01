package com.example.myapplication.util

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Contributors {
    @SerializedName("login")
    @Expose
    private var login: String? = null
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("node_id")
    @Expose
    private var nodeId: String? = null
    @SerializedName("url")
    @Expose
    private var url: String? = null
    @SerializedName("html_url")
    @Expose
    private var htmlUrl: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("site_admin")
    @Expose
    private var siteAdmin: Boolean? = null
    @SerializedName("contributions")
    @Expose
    private var contributions: Int? = null

    fun getLogin(): String? {
        return login
    }

    fun setLogin(login: String) {
        this.login = login
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getNodeId(): String? {
        return nodeId
    }

    fun setNodeId(nodeId: String) {
        this.nodeId = nodeId
    }


    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getHtmlUrl(): String? {
        return htmlUrl
    }

    fun setHtmlUrl(htmlUrl: String) {
        this.htmlUrl = htmlUrl
    }


    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getSiteAdmin(): Boolean? {
        return siteAdmin
    }

    fun setSiteAdmin(siteAdmin: Boolean?) {
        this.siteAdmin = siteAdmin
    }

    fun getContributions(): Int? {
        return contributions
    }

    fun setContributions(contributions: Int?) {
        this.contributions = contributions
    }
}