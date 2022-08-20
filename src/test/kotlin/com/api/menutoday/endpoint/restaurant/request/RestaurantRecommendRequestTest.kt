package com.api.menutoday.endpoint.restaurant.request

import com.api.menutoday.common.util.address.AddressCode
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

internal class RestaurantRecommendRequestTest {

    @Test
    fun getAddress() {
        //given
        val sut = RestaurantRecommendRequest("APQUJUNG_OFFICE", null)

        //when
        val address = sut.getAddress()

        //then
        assertThat(address,`is`(AddressCode.SPOT_ONE.address))
    }
}