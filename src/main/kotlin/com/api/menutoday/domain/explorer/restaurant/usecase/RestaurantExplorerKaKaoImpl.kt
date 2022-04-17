package com.api.menutoday.domain.explorer.restaurant.usecase

import com.api.menutoday.common.util.http.HttpUtil
import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse.Companion.bodyMap
import com.api.menutoday.domain.explorer.restaurant.model.Address
import com.api.menutoday.domain.explorer.restaurant.model.Restaurant
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

/*
    사용한 API
    https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-keyword
    https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-category

 */
@Service
class RestaurantExplorerKaKaoImpl(
    private val httpclient: HttpUtil,
    private val objectMapper: ObjectMapper
) : RestaurantExplorer {

    override fun searchRestaurant(
        address: Address
    ): List<Restaurant> {
        return getRestaurant(address)
    }

    override fun recommendRestaurant(
        address : Address
    ): List<Restaurant> {
        return randomPickFive(getRestaurant(address))
    }

    override fun recommendRestaurant(
        address: Address,
        menu: String
    ): List<Restaurant> {
        return randomPickFive(getRestaurantByMenu(address, menu))
    }

    override fun randomRestaurant(
        address: Address
    ): Restaurant {
        return randomPickOne(getRestaurant(address))
    }

    override fun randomRestaurant(
        address: Address,
        menu: String)
    : Restaurant {
        return randomPickOne(getRestaurantByMenu(address, menu))
    }

    private fun kakaoSearchRequest(address: Address, url : String): HttpRequest {
        return HttpRequest(url = url)
            .addHeader("Authorization", "KakaoAK 494febc0331b78332c4b75a58bd2d8a5")
            .addParam("x", address.x)
            .addParam("y", address.y)
            .addParam("radius", 500)
            .addParam("category_group_code", "FD6")
    }

    private fun getRestaurant(address: Address): List<Restaurant> {
        val request = kakaoSearchRequest(address, "https://dapi.kakao.com/v2/local/search/keyword.json")

        val response = httpclient.get(request)

        return objectMapper.bodyMap<KakaoResponse>(response.body).documents
    }

    private fun getRestaurantByMenu(
        address: Address,
        menu: String
    ): List<Restaurant> {
        val request = kakaoSearchRequest(address, "https://dapi.kakao.com/v2/local/search/category.json")
            .addParam("query", menu, Charsets.UTF_8)

        val response = httpclient.get(request)

        return objectMapper.bodyMap<KakaoResponse>(response.body).documents
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