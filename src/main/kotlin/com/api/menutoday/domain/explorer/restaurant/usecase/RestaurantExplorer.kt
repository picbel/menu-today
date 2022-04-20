package com.api.menutoday.domain.explorer.restaurant.usecase

import com.api.menutoday.domain.explorer.restaurant.aggregate.Address
import com.api.menutoday.domain.explorer.restaurant.aggregate.Restaurant

interface RestaurantExplorer {
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

    fun randomPickOne(
        list : List<Restaurant>
    ) : Restaurant
    = list
        .shuffled()
        .first()

    // todo 지금은 그냥 5개 랜덤추천인데 거리, 가격, 평점등으로 추후엔 줄수 있지 않을까...?
    fun randomPickFive(
        list : List<Restaurant>
    ) : List<Restaurant>
    = list
        .shuffled()
        .stream()
        .limit(5)
        .toList()

}