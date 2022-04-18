package com.api.menutoday.common.util.http

import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.common.util.http.model.HttpResponse
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

// 동시에 여러곳에서 주입받아 사용하는데 문제가 없을려나...? 이거 물어보자
@Service
internal class HttpUtilImpl(
) : HttpUtil{

    override fun get(request : HttpRequest): HttpResponse {
        val con : HttpURLConnection = connect(request.urlAssemble());
        try {
            con.requestMethod = "GET"
            return call(con,request)
        } catch (e : IOException) {
            throw RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }

    }

    private fun setHeader(
        con: HttpURLConnection,
        request: HttpRequest
    ) : HttpURLConnection{
        for (header in request.requestHeaders.entries) {
            con.setRequestProperty(header.key, header.value)
        }
        return con
    }

    private fun call(
        con: HttpURLConnection,
        request : HttpRequest
    ): HttpResponse {
        setHeader(con, request)
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

    private fun connect(apiUrl : String) : HttpURLConnection {
        try {
            val url = URL(apiUrl);
            return url.openConnection() as HttpURLConnection
        } catch (e : MalformedURLException) {
            throw RuntimeException("API URL이 잘못되었습니다. : $apiUrl", e)
        } catch (e : IOException) {
            throw RuntimeException("연결이 실패했습니다. : $apiUrl", e)
        }
    }

    private fun readBody (body : InputStream) : String{
        val streamReader = InputStreamReader(body, StandardCharsets.UTF_8);
        try  {
            val lineReader =  BufferedReader(streamReader)
            val responseBody = StringBuilder()
            lineReader.forEachLine {
                responseBody.append(it)
            }
            return responseBody.toString()
        } catch (e : IOException) {
            throw RuntimeException("API 응답을 읽는데 실패했습니다.", e)
        }
    }
}