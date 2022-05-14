package com.api.menutoday.endpoint.restaurant.request

import com.api.menutoday.common.util.address.AddressCode
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RestaurantRecommendRequestTest {

    @Test
    fun getAddress() {
        //given
        val sut = RestaurantRecommendRequest("APQUJUNG_OFFICE", null)

        //when
        val address = sut.getAddress()

        //then
        assertThat(address,`is`(AddressCode.APQUJUNG_OFFICE.address))
    }
}