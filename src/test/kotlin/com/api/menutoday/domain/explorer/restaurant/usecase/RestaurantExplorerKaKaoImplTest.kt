package com.api.menutoday.domain.explorer.restaurant.usecase

import com.api.menutoday.common.util.http.HttpUtil
import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.domain.explorer.restaurant.fixture.HttpUtilImplWithRestaurantResolver
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(HttpUtilImplWithRestaurantResolver::class)
class RestaurantExplorerKaKaoImplTest{

    private lateinit var sut : RestaurantExplorerKaKaoImpl

    @BeforeEach
    fun setUp(httpUtil : HttpUtil){
        sut = RestaurantExplorerKaKaoImpl(httpUtil, ObjectMapper())
    }

    @Test
    fun test(){

    }
}