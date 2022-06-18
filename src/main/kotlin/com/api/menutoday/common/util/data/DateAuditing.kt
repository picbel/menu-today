package com.api.menutoday.common.util.data

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant

interface DateAuditing {

    @get:CreatedDate
    var createDate : Instant

    @get:LastModifiedDate
    var updateDate : Instant?

}