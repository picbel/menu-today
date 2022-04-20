package com.api.menutoday.endpoint.restaurant.request

import com.api.menutoday.common.util.address.AddressCode


data class RestaurantRecommendRequest(
    val address: AddressCode,
    val menu : String?
)