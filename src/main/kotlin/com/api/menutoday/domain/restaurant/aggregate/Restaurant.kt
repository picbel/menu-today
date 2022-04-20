package com.api.menutoday.domain.restaurant.aggregate

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
class Restaurant(
    val addressName: String,
    val categoryGroupCode: String,
    val categoryGroupName: String,
    val categoryName: String,
    val distance: String, // 좌표로부터의 거리
    val id: String,
    val phone: String,
    val placeName: String,
    val placeUrl: String,
    val roadAddressName: String,
    val x: String,
    val y: String
){
    override fun toString(): String {
        return "Restaurant(addressName='$addressName', categoryGroupCode='$categoryGroupCode', categoryGroupName='$categoryGroupName', categoryName='$categoryName', distance='$distance', id='$id', phone='$phone', placeName='$placeName', placeUrl='$placeUrl', roadAddressName='$roadAddressName', x='$x', y='$y')"
    }
}