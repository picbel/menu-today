package com.api.menutoday.domain.restaurant.repository

import com.api.menutoday.domain.restaurant.aggregate.Restaurant

class RestaurantRepositoryImpl(
    private val restaurantReadonlyRepository : RestaurantReadonlyRepository,
    private val restaurantDao : RestaurantJpaDao
) : RestaurantRepository, RestaurantReadonlyRepository by restaurantReadonlyRepository{

    override fun saveAll(restaurant: Restaurant) {
        TODO("Not yet implemented")
    }

}