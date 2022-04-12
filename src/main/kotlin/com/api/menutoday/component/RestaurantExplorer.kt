package com.api.menutoday.component

import com.api.menutoday.domain.restaurant.Restaurant

interface RestaurantExplorer {
    fun search(
        keyWord : String,
        address : String
    ): List<Restaurant>
}