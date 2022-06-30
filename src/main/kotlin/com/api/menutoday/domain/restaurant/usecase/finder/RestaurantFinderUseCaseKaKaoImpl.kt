package com.api.menutoday.domain.restaurant.usecase.finder

import com.api.menutoday.common.util.http.HttpClient
import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse.Companion.bodyMap
import com.api.menutoday.domain.restaurant.aggregate.Address
import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import java.util.stream.IntStream

/*
    사용한 API
    https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-keyword
    https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-category
 */
@Service
internal class RestaurantFinderUseCaseKaKaoImpl(
    private val httpclient: HttpClient,
    private val objectMapper: ObjectMapper
) : RestaurantFinderUseCase {

    override fun searchRestaurant(
        address: Address
    ): List<Restaurant> {
        return getRestaurantCallApi(address)
    }

    override fun recommendRestaurant(
        address : Address
    ): List<Restaurant> {
        return getRestaurantCallApi(address).randomPickFive()
    }

    override fun recommendRestaurant(
        address: Address,
        menu: String
    ): List<Restaurant> {
        return getRestaurantByMenuCallApi(address, menu).randomPickFive()
    }

    override fun randomRestaurant(
        address: Address
    ): Restaurant {
        return getRestaurantCallApi(address).randomPickOne()
    }

    override fun randomRestaurant(
        address: Address,
        menu: String
    ): Restaurant {
        return getRestaurantByMenuCallApi(address, menu).randomPickOne()
    }

    private fun getRestaurantCallApi(address: Address): List<Restaurant> {
        return apiCall(
            kakaoSearchRequest(address, "https://dapi.kakao.com/v2/local/search/category.json")
        )
    }

    private fun getRestaurantByMenuCallApi(
        address: Address,
        menu: String
    ): List<Restaurant> {
        return apiCall(
            kakaoSearchRequest(address, "https://dapi.kakao.com/v2/local/search/keyword.json")
                .addParam("query", menu, Charsets.UTF_8)
        )
    }

    /*
        현재 음식점 말고는 다른 검색을 허용할 생각이 없어 카테고리 그룹코드를 고정시켯다.
        radius값은 반경검색 거리 단위는 M이다
        현재는 350M을 걷는 거리로 생각하고 있다.
     */
    private fun kakaoSearchRequest(address: Address, url : String): HttpRequest {
        return HttpRequest(url = url)
            .addHeader("Authorization", "KakaoAK 494febc0331b78332c4b75a58bd2d8a5")
            .addParam("x", address.x)
            .addParam("y", address.y)
            .addParam("radius", 350)
            .addParam("category_group_code", "FD6")
    }

    private fun apiCall(request: HttpRequest): List<Restaurant> {
        val response = httpclient.get(request)
        val body = objectMapper.bodyMap<KakaoResponse>(response.body)

        return if (body.meta.isEnd) body.documents else callApiToTheEnd(body, request)
    }

    private fun callApiToTheEnd(
        body: KakaoResponse,
        request: HttpRequest
    ): MutableList<Restaurant> {
        return  body.documents.toMutableSet().apply {
            this.addAll(IntStream.range(2,(body.meta.pageableCount+1))
                .mapToObj {
                    objectMapper.bodyMap<KakaoResponse>(
                        httpclient.get(
                            request.copy().addParam("page", it)
                        ).body
                    ).documents
                }
                .toList()
                .flatten()
                .toMutableSet()
            )  }
            .toMutableList()
    }

    private data class KakaoResponse(
        val meta : KakaoMeta,

        /*
            Restaurant 인터페이스로 만든 이유는 model이라는 세부구현을 숨기기 위함이지만 objcetMapper의 이용을 위해 해당 클래스에 노출함
            대신 해당 클래스를 private로 두어 다른곳에서 사용이 불가능하게 하여 해당 모델의 접근을 제한하도록 함
         */
        val documents : List<Restaurant.Model>
    )

    private data class KakaoMeta(
        val isEnd :Boolean,
        val pageableCount: Int,
        val totalCount: Int
    )

    private fun List<Restaurant>.randomPickOne() : Restaurant = this.shuffled().first()

    // todo 지금은 그냥 5개 랜덤추천인데 거리, 가격, 평점등으로 추후엔 줄수 있지 않을까...?
    private fun List<Restaurant>.randomPickFive(): List<Restaurant>
            = this
        .shuffled()
        .stream()
        .limit(5)
        .toList()
}