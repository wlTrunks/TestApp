package com.lingdtkhe.domain.common.exception

/**
 * Base error class for this test
 * [NetworkError] error represent out of internet error
 * [ExceptionError] other types of exceptions
 * [FeatureError] error of feature
 */
sealed class BaseError(message: String? = null) : Exception(message) {
    class NetworkError(val code: Int, message: String?) : BaseError(message)
    class FeatureError(message: String) : BaseError(message)
    class ExceptionError(e: Exception) : BaseError(message = e.message)
}