package com.api.menutoday.common.util.http.model

import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.nio.charset.Charset


class HttpRequest(
    val url : String,
    val requestHeaders : MutableMap<String,String> = HashMap(),
    private val queryParameters : MutableMap<String,Any> = HashMap()
//    val body : String 추후 바디필요하면 그때 여는걸로
    ) {

    fun addHeader(key : String, value : String): HttpRequest {
        requestHeaders[key] = value
        return this
    }

    fun addParam(key : String, value : Any) : HttpRequest{
        queryParameters[key] = value
        return this
    }

    fun addParam(key: String, value: String, encodeType: Charset) : HttpRequest{
        try{
            queryParameters[key] = URLEncoder.encode(value, encodeType.toString())
            return this
        } catch (e : UnsupportedEncodingException) {
            throw RuntimeException("encoding fail!",e)
        }
    }

    fun urlAssemble() : String{
        if (queryParameters.isEmpty()){
            return url
        }

        val parameter = StringBuilder()
        for (param in queryParameters.entries) {
            parameter.append("${param.key}=${param.value}&")
        }

        return "$url?${parameter.substring(0, parameter.length - 1)}"
    }

    override fun toString(): String {
        return "HttpRequest(url=${urlAssemble()}, requestHeaders=$requestHeaders)"
    }

    fun copy() : HttpRequest = HttpRequest(url, requestHeaders, queryParameters)

}