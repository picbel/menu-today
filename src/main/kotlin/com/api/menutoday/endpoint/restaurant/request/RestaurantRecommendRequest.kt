package com.api.menutoday.endpoint.restaurant.request

import com.api.menutoday.common.util.address.AddressCode
import com.api.menutoday.domain.restaurant.aggregate.Address
import com.fasterxml.jackson.annotation.JsonProperty


data class RestaurantRecommendRequest(
    @JsonProperty("address")
    private val address: String,
    @JsonProperty("menu")
    val menu : String?
){
    fun getAddress() : Address{
        try{
            return AddressCode.valueOf(this.address).address
        }catch (e : Exception){
            throw IllegalArgumentException("입력하신 장소 코드를 확인하여주세요. 혹은 현재 지원하지 않는 주소입니다.")
        }
    }
}