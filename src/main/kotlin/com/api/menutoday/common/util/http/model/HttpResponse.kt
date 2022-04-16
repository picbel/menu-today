package com.api.menutoday.common.util.http.model

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpMethod


class HttpResponse(
    val method: HttpMethod,
    val message: String,
    val code: Int,
    val body: String,
    val request: HttpRequest
) {

    override fun toString(): String {
        return "HttpResponse(method=$method, message='$message', code=$code, body=$body, request=$request)"
    }

    companion object{
        // todo reified 이부분 확인하기 inline의 역할은? type 지우기 정확히 알아보기
        inline fun <reified T> ObjectMapper.bodyMap(body : String): T {
            return readValue<T>(body,T::class.java)
        }
    }
}