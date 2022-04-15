package com.api.menutoday

import com.api.menutoday.common.util.http.HttpUtilImpl
import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse.Companion.bodyMap
import com.api.menutoday.config.JsonConfig
import com.api.menutoday.domain.explorer.restaurant.usecase.RestaurantExplorerKaKaoImpl
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity.ok
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.web.servlet.function.ServerResponse.ok
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

//@Disabled
// 외부api의 데이터를 확인할려고 하는 것이니 실제 테스트와 관련 없습니다.
class ApiCall {

    fun objectMapper(): ObjectMapper {
        return JsonConfig().objectMapper()
    }
//    @Test
//    fun apiCall(){
//
//        var keyword : String = "신사동 567-28 치킨"
//        try {
//            keyword = URLEncoder.encode(keyword, "UTF-8");
//        } catch (e : UnsupportedEncodingException) {
//            throw RuntimeException("encoding fail!",e);
//        }
//        val request = HttpRequest(
//            url = "https://openapi.naver.com/v1/search/local.json?query=$keyword&display=20&start=1&sort=random"
//        )
//            .addHeader("X-Naver-Client-Id","")
//            .addHeader("X-Naver-Client-Secret","")
//
//        val http = HttpUtilImpl()
//        val response = http.get(request)
//
//
//    }

    @Test
    fun apiCalladress(){
        var address : String = "논현로159길 18"

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/address.json"
        )
            .addHeader("Authorization","KakaoAK 494febc0331b78332c4b75a58bd2d8a5")
            .addParam("query", address, Charsets.UTF_8)


        val http = HttpUtilImpl()
        val response = http.get(request)

        assertThat(response.code,`is`(HttpStatus.OK.value()))

    }

    @Test
    fun apiCallk(){
        var keyword : String = "치킨"

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/keyword.json"
        )
            .addHeader("Authorization","KakaoAK 494febc0331b78332c4b75a58bd2d8a5")
            .addParam("y",37.5231498089109)
            .addParam("x",127.026612890604)
            .addParam("radius",500)
            .addParam("category_group_code","FD6")
            .addParam("query", keyword, Charsets.UTF_8)


        val http = HttpUtilImpl()
        val response = http.get(request)

        assertThat(response.code,`is`(HttpStatus.OK.value()))

    }

    @Test
    fun apiCallCate(){

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/category.json"
        )
            .addHeader("Authorization","KakaoAK 494febc0331b78332c4b75a58bd2d8a5")
            .addParam("y",37.514322572335935)
            .addParam("x",127.06283102249932)
            .addParam("radius",1000)
            .addParam("category_group_code","FD6")
//            .addParam("query", keyword, Charsets.UTF_8)



        val http = HttpUtilImpl()
        val response = http.get(request)

        assertThat(response.code,`is`(HttpStatus.OK.value()))

    }

}