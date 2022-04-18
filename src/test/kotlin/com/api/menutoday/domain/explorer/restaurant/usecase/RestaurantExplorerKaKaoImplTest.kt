package com.api.menutoday.domain.explorer.restaurant.usecase

import com.api.menutoday.common.util.http.HttpUtil
import com.api.menutoday.config.ObjectMapperConfig
import com.api.menutoday.domain.explorer.restaurant.fixture.HttpUtilImplWithRestaurantResolver
import com.api.menutoday.domain.explorer.restaurant.model.Address
import com.api.menutoday.domain.explorer.restaurant.model.Restaurant
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(HttpUtilImplWithRestaurantResolver::class)
class RestaurantExplorerKaKaoImplTest{

    private lateinit var sut : RestaurantExplorerKaKaoImpl

    val categoryCode = "FD6"

    @BeforeEach
    fun setUp(httpUtil : HttpUtil){
        sut = RestaurantExplorerKaKaoImpl(httpUtil, ObjectMapperConfig().objectMapper())
    }

    private fun companyOffice(): Address {
        return Address(
            x = "37.514322572335935",
            y = "127.06283102249932",
            addressName = "설로인 압구정 사무실"
        )
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