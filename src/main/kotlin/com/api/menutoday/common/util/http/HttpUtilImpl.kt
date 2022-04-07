package com.api.menutoday.common.util.http

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import org.springframework.stereotype.Service

@Service
internal class HttpUtilImpl(
    private val okHttpClient: OkHttpClient,
    private val objectMapper: ObjectMapper
) : HttpUtil{

    override fun post(): HttpResponse {
        TODO("Not yet implemented")
    }

    override fun put(): HttpResponse {
        TODO("Not yet implemented")
    }

    override fun get(): HttpResponse {
        TODO("Not yet implemented")
    }

    override fun delete(): HttpResponse {
        TODO("Not yet implemented")
    }

}