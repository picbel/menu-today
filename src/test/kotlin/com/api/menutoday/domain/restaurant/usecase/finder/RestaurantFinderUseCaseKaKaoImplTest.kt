package com.api.menutoday.domain.restaurant.usecase.finder

import com.api.menutoday.common.util.address.AddressCode
import com.api.menutoday.common.util.http.HttpUtil
import com.api.menutoday.config.ObjectMapperConfig
import com.api.menutoday.domain.restaurant.fixture.HttpUtilImplWithRestaurantResolver
import com.api.menutoday.domain.restaurant.aggregate.Address
import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import com.api.menutoday.domain.restaurant.usecase.finder.RestaurantFinderUseCaseKaKaoImpl
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(HttpUtilImplWithRestaurantResolver::class)
class RestaurantFinderUseCaseKaKaoImplTest{

    private lateinit var sut : RestaurantFinderUseCaseKaKaoImpl

    private val categoryCode = "FD6"

    @BeforeEach
    fun setUp(httpUtil : HttpUtil){
        sut = RestaurantFinderUseCaseKaKaoImpl(httpUtil, ObjectMapperConfig().objectMapper())
    }

    private fun companyOffice(): Address {
        return AddressCode.APQUJUNG_OFFICE.address
    }

    @Test
    fun searchRestaurant() {
        //given
        val address = companyOffice()

        //when
        val restaurants = sut.searchRestaurant(address)

        //then
        assertThat(restaurants.size, `is`(15))
    }


    @Test
    fun recommendRestaurant(){
        //given
        val address = companyOffice()

        //when
        val restaurants = sut.recommendRestaurant(address)

        //then
        assertThat(restaurants.size, `is`(5))
    }

    @Test
    fun recommendRestaurantByMenu(){
        //given
        val address = companyOffice()
        val menu = "치킨"

        //when
        val restaurants = sut.recommendRestaurant(address,menu)

        //then
        assertAll({
            assertThat(assertCode(restaurants), `is`(true))
            assertThat(restaurants.size, `is`(5))
        })

    }
    @Test
    fun randomRestaurant(){
        //given
        val address = companyOffice()

        //when
        val restaurant = sut.randomRestaurant(address)

        //then
        assertThat(restaurant.categoryGroupCode, `is`(categoryCode))
    }

    @Test
    fun randomRestaurantByMenu(){
        //given
        val address = companyOffice()
        val menu = "치킨"

        //when
        val restaurant = sut.randomRestaurant(address,menu)

        //then
        assertAll({
            assertThat(restaurant.categoryGroupCode, `is`(categoryCode))
        })

    }

    private fun assertCode(restaurants :List<Restaurant>) : Boolean{
        return restaurants.stream().allMatch{
               it.categoryGroupCode == categoryCode
           }
    }
}