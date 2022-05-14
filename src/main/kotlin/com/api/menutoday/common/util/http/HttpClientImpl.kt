package com.api.menutoday.common.util.http

import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.nio.charset.StandardCharsets

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
internal class HttpClientImpl(
) : HttpClient {

    override fun get(request: HttpRequest): HttpResponse {
        connect(request.urlAssemble()).run {
            try {
                this.requestMethod = HttpMethod.GET.name
                setHeader(this, request)
                return call(this, request)
            } catch (e: IOException) {
                throw RuntimeException("API 요청과 응답 실패", e);
            } finally {
                this.disconnect();
            }
        }
    }

    private fun setHeader(
        con: HttpURLConnection,
        request: HttpRequest
    ): HttpURLConnection {
        return request.requestHeaders.entries.stream().forEach {
            con.setRequestProperty(it.key, it.value)
        }.let { con }
    }

    private fun call(
        con: HttpURLConnection,
        request: HttpRequest
    ): HttpResponse {
        if (con.responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
            return HttpResponse(
                method = HttpMethod.valueOf(con.requestMethod),
                code = con.responseCode,
                message = con.responseMessage,
                body = readBody(con.inputStream),
                request = request
            )
        } else { // 에러 발생
            return HttpResponse(
                method = HttpMethod.valueOf(con.requestMethod),
                code = con.responseCode,
                message = con.responseMessage,
                body = readBody(con.errorStream),
                request = request
            )
        }
    }

    private fun connect(apiUrl: String): HttpURLConnection {
        try {
            return URL(apiUrl).openConnection() as HttpURLConnection
        } catch (e: MalformedURLException) {
            throw RuntimeException("API URL이 잘못되었습니다. : $apiUrl", e)
        } catch (e: IOException) {
            throw RuntimeException("연결이 실패했습니다. : $apiUrl", e)
        }
    }

    private fun readBody(body: InputStream): String {
        return InputStreamReader(body, StandardCharsets.UTF_8).use{
            try {
                BufferedReader(it).run {
                    StringBuilder().append(it)
                }.toString()
            } catch (e: IOException) {
                throw RuntimeException("API 응답을 읽는데 실패했습니다.", e)
            }
        }
    }

}