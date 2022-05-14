package com.api.menutoday.domain.restaurant.aggregate


import java.time.LocalDate

class RestaurantInfo(
    val restaurant: Restaurant,
    val reviewCount : Int,
    val score : Double,
    val averagePrice : Int,
    val highestPrice : Int,
    val lowestPrice : Int,
    val infoLastUpdated : LocalDate
) {

}