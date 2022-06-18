package com.api.menutoday.domain.restaurant.aggregate

interface Address{
    val addressName: String
    val x: String
    val y: String

    class Model(
        override val addressName: String,
        override val x: String,
        override val y: String,
//    var bCode: String?,
//    var hCode: String?,
//    var mainAddressNo: String?,
//    var mountainYn: String?,
//    var region1DepthName: String?,
//    var region2DepthName: String?,
//    var region3DepthHName: String?,
//    var region3DepthName: String?,
//    var subAddressNo: String?,
    ) : Address{

    }

    companion object{
        fun create(
            addressName: String,
            x: String,
            y: String
        ) : Model = Model(
            addressName, x, y
        )
    }
}
