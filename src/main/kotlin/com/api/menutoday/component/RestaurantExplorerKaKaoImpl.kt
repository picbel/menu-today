package com.api.menutoday.component

import com.api.menutoday.common.util.http.HttpUtil
import com.api.menutoday.domain.restaurant.Restaurant


class RestaurantExplorerKaKaoImpl(
    private val httpclient: HttpUtil
) : RestaurantExplorer {

    /*
    https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-keyword
    https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-category
     */
    private fun urlAssemble(keyWord : String) : String{
        return "https://openapi.naver.com/v1/search/local.json?query=$keyWord&display=10&start=1&sort=random"
    }

    override fun search(
        keyWord : String,
        address : String
    ): List<Restaurant> {
        TODO("Not yet implemented")



//        httpclient.get(HttpRequest())




        return listOf(Restaurant())
    }
}