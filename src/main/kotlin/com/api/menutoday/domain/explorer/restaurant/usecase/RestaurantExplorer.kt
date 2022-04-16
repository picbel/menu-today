package com.api.menutoday.domain.explorer.restaurant.usecase

import com.api.menutoday.domain.explorer.restaurant.model.Address
import com.api.menutoday.domain.explorer.restaurant.model.Restaurant

interface RestaurantExplorer {
    fun searchKeyword(
        keyWord : String,
        address : Address
    ): List<Restaurant>
}