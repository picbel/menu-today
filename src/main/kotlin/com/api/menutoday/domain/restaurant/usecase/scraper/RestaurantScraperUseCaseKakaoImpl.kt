package com.api.menutoday.domain.restaurant.usecase.scraper

import com.api.menutoday.domain.restaurant.aggregate.Address
import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import com.api.menutoday.domain.restaurant.aggregate.RestaurantInfo
import com.api.menutoday.domain.restaurant.repository.RestaurantRepository
import com.api.menutoday.domain.restaurant.usecase.finder.RestaurantFinderUseCase

class RestaurantScraperUseCaseKakaoImpl(
    private val restaurantFinder: RestaurantFinderUseCase,
    private val repository: RestaurantRepository
) : RestaurantScraperUseCase {

    override fun scrapRestaurant(address: Address) : List<Restaurant> {

        val restaurants = restaurantFinder.searchRestaurant(address)



        TODO("필요한 정보가 무엇인가 어떻게 정제를 해야할까?, 이후 저장")
    }

}