package com.api.menutoday.domain.restaurant.fixture

import com.api.menutoday.common.util.http.HttpUtil
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver

class RestaurantHttpUtilImplResolver : ParameterResolver {
    override fun supportsParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Boolean {
      return parameterContext!!.parameter.type == HttpUtil::class.java
    }

    override fun resolveParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Any {
        return TestRestaurantHttpUtil()
    }
}