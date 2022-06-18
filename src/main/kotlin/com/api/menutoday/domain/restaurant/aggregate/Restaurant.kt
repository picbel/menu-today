package com.api.menutoday.domain.restaurant.aggregate

import com.fasterxml.jackson.annotation.JsonProperty

/*
    {
    "address_name":"서울 강남구 신사동 646-8",
    "category_group_code":"FD6",
    "category_group_name":"음식점",
    "category_name":"음식점 \u003e 치킨",
    "distance":"909","id":"83108266",
    "phone":"02-3447-3456",
    "place_name":"롸카두들 핫치킨 압구정점",
    "place_url":"http://place.map.kakao.com/83108266",
    "road_address_name":"서울 강남구 언주로164길 35-3",
    "x":"127.03643182404942",
    "y":"37.52560341079871"
    }
*/
interface Restaurant {
    val apiId: String
    val source: String
    val addressName: String
    val categoryGroupCode: String
    val categoryGroupName: String
    val categoryName: String

    /**
     * 좌표로부터의 거리
     */
    val distance: String
    val phone: String
    val placeName: String
    val placeUrl: String
    val roadAddressName: String
    val x: String
    val y: String

    class Model(
        @JsonProperty("id")
        override val apiId: String,
        // 지금은 카카오만 있어서 그냥 박아놧다 추후에 api를 바꾼다면 하드코딩바꿔야함!
        override val source: String = "kakao",
        override val addressName: String,
        override val categoryGroupCode: String,
        override val categoryGroupName: String,
        override val categoryName: String,
        override val distance: String, // 좌표로부터의 거리
        override val phone: String,
        override val placeName: String,
        override val placeUrl: String,
        override val roadAddressName: String,
        override val x: String,
        override val y: String,
    ) : Restaurant {
        //todo Restaurant의 hash 는 apiId와 source로 비교한다
        override fun toString(): String {
            return "Restaurant(addressName='$addressName', categoryGroupCode='$categoryGroupCode', categoryGroupName='$categoryGroupName', categoryName='$categoryName', distance='$distance', id='$apiId', phone='$phone', placeName='$placeName', placeUrl='$placeUrl', roadAddressName='$roadAddressName', x='$x', y='$y')"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Model

            if (apiId != other.apiId) return false
            if (source != other.source) return false

            return true
        }

        override fun hashCode(): Int {
            var result = apiId.hashCode()
            result = 31 * result + source.hashCode()
            return result
        }

    }
}