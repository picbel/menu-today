package com.api.menutoday.domain.restaurant.repository.entity

import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.Table

@Entity
@IdClass(RestaurantEntityPk::class)
@Table(name = "restaurant")
class RestaurantEntity constructor(
    /*
        도메인 모델 상속은 포기
        그냥 변환로직 잘만들자... 괜히 몇줄아낄려다 jpa 기능하고 충돌나서 뻘짓하는거보다 좋다
        id 는 복합키로 구성하였다.
     */
    @Id
    val apiId: String,
    @Id
    val source: String,
    val addressName: String,
    val categoryGroupCode: String,
    val categoryGroupName: String,
    val categoryName: String,
    val distance: String,
    val phone: String,
    val placeName: String,
    val placeUrl: String,
    val roadAddressName: String,
    val x: String,
    val y: String,
) {
    companion object{
        fun from(src: Restaurant): RestaurantEntity = with(src) {
            RestaurantEntity(
                addressName = addressName,
                categoryGroupCode = categoryGroupCode,
                categoryGroupName = categoryGroupName,
                categoryName = categoryName,
                distance = distance,
                apiId = apiId,
                phone = phone,
                placeName = placeName,
                placeUrl = placeUrl,
                roadAddressName = roadAddressName,
                x = x,
                y = y,
                source = source
            )
        }
    }
}