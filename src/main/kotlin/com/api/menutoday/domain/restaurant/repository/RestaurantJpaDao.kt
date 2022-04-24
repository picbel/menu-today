package com.api.menutoday.domain.restaurant.repository

import com.api.menutoday.domain.restaurant.repository.entity.RestaurantEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantJpaDao : JpaRepository<RestaurantEntity,Long>{
}