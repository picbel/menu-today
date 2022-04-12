package com.api.menutoday.common.util.http.model

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpMethod


data class HttpResponse(
    private val objectMapper: ObjectMapper,
    val method: HttpMethod,
    val message: String,
    val code: Int,
    val body: String?,
    val request: HttpRequest
){

    fun <T> map(type : T ) : T{
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "HttpResponse(method=$method, message='$message', code=$code, body=$body, request=$request)"
    }
}
