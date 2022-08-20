package com.api.menutoday.common.util.address

import com.api.menutoday.domain.restaurant.aggregate.Address

enum class AddressCode(
    val address: Address
) {
    SPOT_ONE(
        Address.create(
            x = "126.924981674031",
            y = "37.4904954867064",
            addressName = "테스트용"
        )
    )

}