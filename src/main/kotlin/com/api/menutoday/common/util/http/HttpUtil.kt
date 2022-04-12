package com.api.menutoday.common.util.http

import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse

interface HttpUtil{

    fun get(request : HttpRequest): HttpResponse

}