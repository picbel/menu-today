package com.api.menutoday.domain.restaurant.usecase.finder

import com.api.menutoday.domain.restaurant.aggregate.Address
import com.api.menutoday.domain.restaurant.aggregate.Restaurant

interface RestaurantFinderUseCase {
    fun searchRestaurant(
        address : Address
    ): List<Restaurant>

    fun recommendRestaurant(
        address : Address
    ): List<Restaurant>

    fun recommendRestaurant(
        address : Address,
        menu: String
    ): List<Restaurant>

    fun randomRestaurant(
        address : Address,
    ): Restaurant

    fun randomRestaurant(
        address : Address,
        menu : String
    ): Restaurant

}