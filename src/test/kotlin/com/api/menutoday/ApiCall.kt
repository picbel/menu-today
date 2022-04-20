package com.api.menutoday

import com.api.menutoday.common.util.http.HttpUtilImpl
import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse.Companion.bodyMap
import com.api.menutoday.config.ObjectMapperConfig
import com.api.menutoday.domain.restaurant.usecase.RestaurantFinderUseCaseKaKaoImpl
import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import java.util.stream.IntStream

@Disabled
// 외부api의 데이터를 확인할려고 하는 것이니 실제 테스트와 관련 없습니다.
class ApiCall {

    private fun objectMapper(): ObjectMapper = ObjectMapperConfig().objectMapper()

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
        val address : String = "논현로159길 18"

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/address.json"
        )
            .addHeader("Authorization","KakaoAK 494febc0331b78332c4b75a58bd2d8a5")
            .addParam("query", address, Charsets.UTF_8)


        val http = HttpUtilImpl()
        val response = http.get(request)

        println(response)
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
            .addHeader("Authorization", "KakaoAK 494febc0331b78332c4b75a58bd2d8a5")
            .addParam("y",37.5231498089109)
            .addParam("x",127.026612890604)
            .addParam("radius", 500)
            .addParam("category_group_code", "FD6")



        val http = HttpUtilImpl()
        val response = http.get(request)

        assertThat(response.code,`is`(HttpStatus.OK.value()))

    }
    @Test
    fun apiCallCate2(){

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/category.json"
        )
            .addHeader("Authorization", "KakaoAK 494febc0331b78332c4b75a58bd2d8a5")
            .addParam("y",37.5231498089109)
            .addParam("x",127.026612890604)
            .addParam("radius", 500)
            .addParam("category_group_code", "FD6")


        val http = HttpUtilImpl()
        val response = http.get(request)
        val body = objectMapper().bodyMap<RestaurantFinderUseCaseKaKaoImpl.KakaoResponse>(response.body)

        val result = body.documents.toMutableList()
            IntStream.range(2,body.meta.pageableCount)
                .forEach {
                    result.addAll(objectMapper().bodyMap<RestaurantFinderUseCaseKaKaoImpl.KakaoResponse>(http.get(request.copy().addParam("page", it)).body).documents)
                }

        assertThat(result.size > 15, `is`(true))

    }

}