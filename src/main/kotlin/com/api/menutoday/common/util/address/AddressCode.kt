package com.api.menutoday.common.util.address

import com.api.menutoday.domain.restaurant.aggregate.Address

enum class AddressCode(
    val address: Address
) {
    APQUJUNG_OFFICE(
        Address.create(
            x = "127.026612890604",
            y = "37.5231498089109",
            addressName = "설로인 압구정 사무실"
        )
    )

}