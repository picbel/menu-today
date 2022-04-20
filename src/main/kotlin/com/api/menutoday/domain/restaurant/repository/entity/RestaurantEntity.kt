package com.api.menutoday.domain.restaurant.repository.entity

import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import org.springframework.data.annotation.Id

class RestaurantEntity constructor(
    @get:Id
    val id : Long?,
    addressName: String,
    categoryGroupCode: String,
    categoryGroupName: String,
    categoryName: String,
    distance: String,
    apiId: String,
    phone: String,
    placeName: String,
    placeUrl: String,
    roadAddressName: String,
    x: String,
    y: String
) : Restaurant(
    addressName = addressName,
    categoryGroupCode = categoryGroupCode,
    categoryGroupName = categoryGroupName,
    categoryName = categoryName,
    distance = distance,
    apiId = apiId,
    phone = phone,
    placeName = placeName,
    placeUrl = placeUrl,
    roadAddressName = roadAddressName,
    x = x,
    y = y
){
    companion object{
        fun from(src: Restaurant): RestaurantEntity = with(src) {
            RestaurantEntity(
                id = (src as? RestaurantEntity)?.id ,
                addressName = addressName,
                categoryGroupCode = categoryGroupCode,
                categoryGroupName = categoryGroupName,
                categoryName = categoryName,
                distance = distance,
                apiId = apiId,
                phone = phone,
                placeName = placeName,
                placeUrl = placeUrl,
                roadAddressName = roadAddressName,
                x = x,
                y = y
            )
        }
    }
}