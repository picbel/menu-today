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

// 장소기반으로 음식점 추천하기
// 카카오 페이지 스크랩핑 하기

