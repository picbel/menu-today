package com.api.menutoday.domain.restaurant.repository.entity

import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "restaurant")
class RestaurantEntity constructor(
    @Id
    val id : Long?,
    val addressName: String,
    val categoryGroupCode: String,
    val categoryGroupName: String,
    val categoryName: String,
    val distance: String,
    val apiId: String,
    val phone: String,
    val placeName: String,
    val placeUrl: String,
    val roadAddressName: String,
    val x: String,
    val y: String
) {
    companion object{
        fun from(src: Restaurant): RestaurantEntity = with(src) {
            RestaurantEntity(
                id = id ,
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