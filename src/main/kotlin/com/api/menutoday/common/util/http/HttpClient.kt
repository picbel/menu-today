package com.api.menutoday.common.util.http

import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse

interface HttpClient{

    fun get(request : HttpRequest): HttpResponse

}