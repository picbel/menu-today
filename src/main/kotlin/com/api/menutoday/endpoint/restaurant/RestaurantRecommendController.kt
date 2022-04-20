package com.api.menutoday.endpoint.restaurant

import com.api.menutoday.domain.restaurant.usecase.finder.RestaurantFinderUseCase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurant")
class RestaurantRecommendController(
    private val finder: RestaurantFinderUseCase
) {
//    @GetMapping("")
//    fun getRestaurant(
//    ): ResponseEntity<*>? {
//        val address = Address(
//            x = "127.026612890604",
//            y = "37.5231498089109",
//            addressName = "설로인 압구정 사무실"
//        )
//        return ResponseEntity.ok(explorer.recommendRestaurant(address))
//    }
}