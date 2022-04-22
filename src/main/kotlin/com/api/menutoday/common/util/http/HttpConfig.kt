package com.api.menutoday.common.util.http

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class HttpConfig {

    @Bean("HttpUtil")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun httpclient(): HttpUtil {
        return HttpUtilImpl()
    }
}