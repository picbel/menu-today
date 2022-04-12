package com.api.menutoday

import com.api.menutoday.common.util.http.HttpUtilImpl
import com.api.menutoday.common.util.http.model.HttpRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

class ApiTest {
    @Test
    fun apiCall(){

        var keyword : String = "신사동 567-28 치킨"
        try {
            keyword = URLEncoder.encode(keyword, "UTF-8");
        } catch (e : UnsupportedEncodingException) {
            throw RuntimeException("encoding fail!",e);
        }
        val request = HttpRequest(
            url = "https://openapi.naver.com/v1/search/local.json?query=$keyword&display=20&start=1&sort=random"
        )
            .addHeader("X-Naver-Client-Id","")
            .addHeader("X-Naver-Client-Secret","")

        val http = HttpUtilImpl(ObjectMapper())
        val response = http.get(request)


        println("네이버에서 받은 결과 = " + response);
        System.out.println("-----------------------------------------");

    }
}