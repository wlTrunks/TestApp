package com.lingdtkhe.data.common

import com.lingdtkhe.domain.common.exception.BaseError
import com.lingdtkhe.domain.common.result.Either

/**
 * Default handler of server response or return error
 */
inline fun <R> proceedResponse(requestBlock: () -> Either.Right<R>): Either<BaseError, R> {
    return try {
        requestBlock.invoke()
    } catch (networkError: BaseError.NetworkError) {
        Either.Left(networkError)
    } catch (e: Exception) {
        Either.Left(BaseError.ExceptionError(e))
    }
}