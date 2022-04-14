package com.api.menutoday.common.util.http.model

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class HttpRequestTest {

    lateinit var sut : HttpRequest

    @BeforeEach
    fun setUp(){
        sut = HttpRequest(url = "http://localhost:8080")
    }

    @Test
    fun addHeader() {
        //given

        //when
        for (i in 0..9)
            sut.addHeader("header$i","header value $i")

        //then
        assertAll({
            assertThat(sut.requestHeaders["header0"],`is`("header value 0"))
            assertThat(sut.requestHeaders.size, `is`(10))
        })

    }

    @Test
    fun urlAssemble() {
        //given

        //when
        for (i in 0..2)
            sut.addParam("key$i","value$i")

        //then
        assertThat(sut.urlAssemble().toSortedSet(),`is`("http://localhost:8080?key0=value0&key1=value1&key2=value2".toSortedSet()))

    }
}