package com.api.menutoday.domain.restaurant.repository

import com.api.menutoday.domain.restaurant.aggregate.Restaurant

interface RestaurantRepository {

    fun save(restaurant: Restaurant) : Restaurant

}