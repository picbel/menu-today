package com.api.menutoday.endpoint.restaurant

import com.api.menutoday.MenuTodayApplication
import com.apple.eawt.Application
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.BDDMockito.given
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [
        MenuTodayApplication::class
    ]
)
class RestaurantRecommendControllerTest {

    @Test
    fun recommendRestaurant() {
        TODO()
    }
}