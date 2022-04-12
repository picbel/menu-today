package com.api.menutoday.component

import com.api.menutoday.common.util.http.HttpUtil
import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.domain.restaurant.Restaurant


class RestaurantExplorerNaverImpl(
    private val httpclient: HttpUtil
) : RestaurantExplorer {

    /*
    https://developers.naver.com/docs/search/local/
    네이버 검색 api url
    그냥 일단 하드코딩
     */
//    private val apiUrl = "https://openapi.naver.com/v1/search/local.json"

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