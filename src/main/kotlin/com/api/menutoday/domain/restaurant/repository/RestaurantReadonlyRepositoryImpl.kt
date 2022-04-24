package com.api.menutoday.domain.restaurant.repository

class RestaurantReadonlyRepositoryImpl(
    private val restaurantDao: RestaurantJpaDao
) : RestaurantReadonlyRepository {
}