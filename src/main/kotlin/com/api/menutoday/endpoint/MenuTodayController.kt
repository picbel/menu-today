package com.api.menutoday.endpoint

import com.api.menutoday.domain.explorer.restaurant.usecase.RestaurantExplorer
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurant")
class MenuTodayController(
    private val explorer: RestaurantExplorer
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