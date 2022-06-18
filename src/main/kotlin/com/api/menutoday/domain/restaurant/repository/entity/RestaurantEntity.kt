package com.api.menutoday.domain.restaurant.repository.entity


import com.api.menutoday.common.util.data.DateAuditing
import com.api.menutoday.domain.restaurant.aggregate.Restaurant
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.Table

@Entity
@IdClass(RestaurantEntityPk::class)
@Table(name = "restaurant")
class RestaurantEntity constructor(
    @Id
    override val apiId: String,
    @Id
    override val source: String,
    override val addressName: String,
    override val categoryGroupCode: String,
    override val categoryGroupName: String,
    override val categoryName: String,
    override val distance: String,
    override val phone: String,
    override val placeName: String,
    override val placeUrl: String,
    override val roadAddressName: String,
    override val x: String,
    override val y: String,
    override var createDate: Instant = Instant.now(),
    override var updateDate: Instant? = null,
) : Restaurant, DateAuditing {
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