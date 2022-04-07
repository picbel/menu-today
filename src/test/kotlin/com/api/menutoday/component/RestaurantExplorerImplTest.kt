package com.api.menutoday.component

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RestaurantExplorerImplTest {

    @Test
    suspend fun search() {
        val sut = RestaurantExplorerImpl()

        sut.search()
    }
}