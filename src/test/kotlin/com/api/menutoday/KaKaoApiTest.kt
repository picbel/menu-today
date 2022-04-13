package com.api.menutoday

import com.api.menutoday.common.util.http.HttpUtilImpl
import com.api.menutoday.common.util.http.model.HttpRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

class KaKaoApiTest {
    @Test
    fun apiCall(){
        var keyword : String = "치킨"
        try {
            keyword = URLEncoder.encode(keyword, "UTF-8");
        } catch (e : UnsupportedEncodingException) {
            throw RuntimeException("encoding fail!",e);
        }

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/keyword.json?y=37.514322572335935&x=127.06283102249932&radius=20000&query=$keyword"
        )
            .addHeader("Authorization","KakaoAK ")


        val http = HttpUtilImpl(ObjectMapper())
        val response = http.get(request)


        println("카카오에서 받은 결과 = " + response);
        System.out.println("-----------------------------------------");

    }

}