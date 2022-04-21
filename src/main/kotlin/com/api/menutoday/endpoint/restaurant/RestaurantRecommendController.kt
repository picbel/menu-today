package com.api.menutoday.endpoint.restaurant

import com.api.menutoday.domain.restaurant.usecase.finder.RestaurantFinderUseCase
import com.api.menutoday.endpoint.restaurant.request.RestaurantRecommendRequest
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
class RestaurantRecommendController(
    private val finder: RestaurantFinderUseCase
) {
    @GetMapping(ApiPaths.RECOMMEND)
    fun recommendRestaurant(
        @ModelAttribute request : RestaurantRecommendRequest
    ): ResponseEntity<*> {
        return ResponseEntity.ok(
            when(request.menu){
                null -> finder.recommendRestaurant(request.getAddress())
                else -> finder.recommendRestaurant(request.getAddress(), request.menu)
            }
        )
    }

    @GetMapping(ApiPaths.RANDOM)
    fun randomRestaurant(
        @ModelAttribute request : RestaurantRecommendRequest
    ): ResponseEntity<*> {
        return ResponseEntity.ok(
            when(request.menu){
                null -> finder.randomRestaurant(request.getAddress())
                else -> finder.randomRestaurant(request.getAddress(), request.menu)
            }
        )
    }
}