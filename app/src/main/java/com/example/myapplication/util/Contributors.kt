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
    @SerializedName("type")
    @Expose
    private var type: String? = null


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

    fun getType(): String? {
        return type
    }


    fun setType(type: String) {
        this.type = type
    }


}