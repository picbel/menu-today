package com.api.menutoday.domain.restaurant.usecase.scraper

import com.api.menutoday.domain.restaurant.aggregate.Address
import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import com.api.menutoday.domain.restaurant.aggregate.RestaurantInfo

interface RestaurantScraperUseCase {

    fun scrapRestaurant(address: Address) : List<Restaurant>
}