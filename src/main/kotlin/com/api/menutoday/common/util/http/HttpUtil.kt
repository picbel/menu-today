package com.api.menutoday.common.util.http

interface HttpUtil{

    fun post() : HttpResponse

    fun put() : HttpResponse

    fun get() : HttpResponse

    fun delete() : HttpResponse

}