package com.api.menutoday.domain.restaurant.repository

class RestaurantRepositoryImpl(
    private val restaurantReadonlyRepository : RestaurantReadonlyRepository,
    private val restaurantDao : RestaurantJpaDao
) : RestaurantRepository, RestaurantReadonlyRepository by restaurantReadonlyRepository{
}