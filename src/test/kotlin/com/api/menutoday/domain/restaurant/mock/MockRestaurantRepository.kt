package com.api.menutoday.domain.restaurant.mock

import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import com.api.menutoday.domain.restaurant.repository.RestaurantRepository

class MockRestaurantRepository : RestaurantRepository{
    override fun saveAll(restaurant: Restaurant) {
        TODO("Not yet implemented")
    }
}