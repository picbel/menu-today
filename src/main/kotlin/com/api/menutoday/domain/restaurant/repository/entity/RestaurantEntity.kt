package com.api.menutoday.domain.restaurant.repository.entity

import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import org.springframework.data.annotation.Id

class RestaurantEntity(
    @get:Id
    val restaurantId : Long,
    addressName: String,
    categoryGroupCode: String,
    categoryGroupName: String,
    categoryName: String,
    distance: String,
    id: String,
    phone: String,
    placeName: String,
    placeUrl: String,
    roadAddressName: String,
    x: String,
    y: String
) : Restaurant(
    addressName,
    categoryGroupCode,
    categoryGroupName,
    categoryName,
    distance,
    id,
    phone,
    placeName,
    placeUrl,
    roadAddressName,
    x,
    y
){
}