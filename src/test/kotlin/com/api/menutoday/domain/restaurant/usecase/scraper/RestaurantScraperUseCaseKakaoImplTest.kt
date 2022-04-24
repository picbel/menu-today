package com.api.menutoday.domain.restaurant.usecase.scraper

import com.api.menutoday.common.util.address.AddressCode
import com.api.menutoday.common.util.http.HttpUtil
import com.api.menutoday.config.ObjectMapperConfig
import com.api.menutoday.domain.restaurant.fixture.RestaurantHttpUtilImplResolver
import com.api.menutoday.domain.restaurant.fixture.RestaurantRepositoryResolver
import com.api.menutoday.domain.restaurant.repository.RestaurantRepository
import com.api.menutoday.domain.restaurant.repository.RestaurantRepositoryImpl
import com.api.menutoday.domain.restaurant.usecase.finder.RestaurantFinderUseCase
import com.api.menutoday.domain.restaurant.usecase.finder.RestaurantFinderUseCaseKaKaoImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(RestaurantHttpUtilImplResolver::class, RestaurantRepositoryResolver::class)
internal class RestaurantScraperUseCaseKakaoImplTest{

    /*
    해당 클래스의 역할은 finder에서 가져온 정보중 url 주소로 평점, 리뷰수, 음식가격 등을 추천해주기 위해 크롤링하는 역할이다
     */

    private lateinit var sut : RestaurantScraperUseCase

    @BeforeEach
    fun setUp(httpUtil : HttpUtil, restaurantRepository: RestaurantRepository){
        sut = RestaurantScraperUseCaseKakaoImpl(
            RestaurantFinderUseCaseKaKaoImpl(httpUtil, ObjectMapperConfig().objectMapper()),
            restaurantRepository
        )
    }

    /*
        레스토랑 정보를 긁어와서 저장하는 메서드
     */
    @Test
    fun scrapRestaurant(){
        //given
        val address = AddressCode.APQUJUNG_OFFICE.address

        //when
        val scrapRestaurant = sut.scrapRestaurant(address)

        //then
    }
}