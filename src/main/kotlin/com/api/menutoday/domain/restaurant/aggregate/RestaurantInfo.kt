package com.api.menutoday.domain.restaurant.aggregate


import java.time.LocalDate

interface RestaurantInfo {
    val restaurant: Restaurant
    val reviewCount: Int
    val score: Double
    val averagePrice: Int
    val highestPrice: Int
    val lowestPrice: Int
    val infoLastUpdated: LocalDate

    class Model(
        override val restaurant: Restaurant,
        override val reviewCount: Int,
        override val score: Double,
        override val averagePrice: Int,
        override val highestPrice: Int,
        override val lowestPrice: Int,
        override val infoLastUpdated: LocalDate

    ) : RestaurantInfo {

    }
}
