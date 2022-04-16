package com.api.menutoday.domain.explorer.restaurant.usecase

import com.api.menutoday.common.util.http.HttpUtil
import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse.Companion.bodyMap
import com.api.menutoday.domain.explorer.restaurant.model.Address
import com.api.menutoday.domain.explorer.restaurant.model.Restaurant
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class RestaurantExplorerKaKaoImpl(
    private val httpclient: HttpUtil,
    private val objectMapper: ObjectMapper
) : RestaurantExplorer {

    /*
    https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-keyword
    https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-category
     */
    private fun urlAssemble(keyWord : String) : String{
        return "https://openapi.naver.com/v1/search/local.json?query=$keyWord&display=10&start=1&sort=random"
    }

    override fun searchKeyword(
        keyWord : String,
        address : Address
    ): List<Restaurant> {
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


        val response = httpclient.get(request)

        val bodyMap = objectMapper.bodyMap<KakaoResponse>(response.body)

        TODO("Not yet implemented")
    }

    internal data class KakaoResponse(
        val meta : KakaoMeta,
        val documents : List<Restaurant>
    )

    internal data class KakaoMeta(
        val isEnd :Boolean,
        val pageableCount: Int,
        val totalCount: Int
    )
}