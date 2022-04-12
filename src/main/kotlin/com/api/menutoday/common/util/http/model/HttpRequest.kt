package com.api.menutoday.common.util.http.model


data class HttpRequest(
    val url : String,
    val requestHeaders : MutableMap<String,String> = HashMap()
//    val body : String 추후 바디 열리면 그때 여는걸로
    ) {

    fun addHeader(key : String, value : String): HttpRequest {
        requestHeaders[key] = value
        return this
    }





}