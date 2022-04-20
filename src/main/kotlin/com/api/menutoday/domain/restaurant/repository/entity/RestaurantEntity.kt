package com.api.menutoday.domain.restaurant.repository.entity

import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import org.springframework.data.annotation.Id

class RestaurantEntity constructor(
    @get:Id
    val restaurantId : Long?,
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
    addressName                  =addressName,
    categoryGroupCode            =categoryGroupCode,
    categoryGroupName            =categoryGroupName,
    categoryName                 =categoryName,
    distance                     =distance,
    id                           =id,
    phone                        =phone,
    placeName                    =placeName,
    placeUrl                     =placeUrl,
    roadAddressName              =roadAddressName,
    x                            =x,
    y                             =y
){
    companion object{
        fun from(src: Restaurant): RestaurantEntity = with(src) {
            RestaurantEntity(
                restaurantId = (src as? RestaurantEntity)?.restaurantId ,
                addressName                  =addressName,
                categoryGroupCode            =categoryGroupCode,
                categoryGroupName            =categoryGroupName,
                categoryName                 =categoryName,
                distance                     =distance,
                id                           =id,
                phone                        =phone,
                placeName                    =placeName,
                placeUrl                     =placeUrl,
                roadAddressName              =roadAddressName,
                x                            =x,
                y                            =y
            )
        }
    }
}