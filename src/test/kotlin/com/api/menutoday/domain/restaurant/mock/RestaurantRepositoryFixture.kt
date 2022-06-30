package com.api.menutoday.domain.restaurant.mock

import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import com.api.menutoday.domain.restaurant.repository.RestaurantRepository

internal class RestaurantRepositoryFixture : RestaurantRepository{
    override fun save(restaurant: Restaurant): Restaurant {
        TODO("Not yet implemented")
    }
}