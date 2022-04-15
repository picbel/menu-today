package com.api.menutoday.domain.explorer.restaurant.model

class Address(
    val addressName: String,
    val bCode: String,
    val hCode: String,
    val mainAddressNo: String,
    val mountainYn: String,
    val region1DepthName: String,
    val region2DepthName: String,
    val region3DepthHName: String,
    val region3DepthName: String,
    val subAddressNo: String,
    val x: String,
    val y: String
){
    override fun toString(): String {
        return "Address(addressName='$addressName', bCode='$bCode', hCode='$hCode', mainAddressNo='$mainAddressNo', mountainYn='$mountainYn', region1DepthName='$region1DepthName', region2DepthName='$region2DepthName', region3DepthHName='$region3DepthHName', region3DepthName='$region3DepthName', subAddressNo='$subAddressNo', x='$x', y='$y')"
    }
}