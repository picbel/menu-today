package com.api.menutoday

import com.api.menutoday.common.util.http.HttpUtilImpl
import com.api.menutoday.common.util.http.model.HttpRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

class KaKaoApiTest {
    @Test
    fun apiCall(){
        var keyword : String = "치킨"

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/keyword.json"
        )
            .addHeader("Authorization","KakaoAK ")
            .addParam("y",37.514322572335935)
            .addParam("x",127.06283102249932)
            .addParam("radius",1000)
            .addParam("query", keyword, Charsets.UTF_8)


        val http = HttpUtilImpl(ObjectMapper())
        val response = http.get(request)


        println("카카오에서 받은 결과 = " + response);
        System.out.println("-----------------------------------------");

    }

}