package com.api.menutoday.common.util.http

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.Response

data class HttpResponse(
    private val objectMapper: ObjectMapper,
    val response : Response?
){
    fun <T> map(type : T ) : T{
        TODO("Not yet implemented")
    }
}
