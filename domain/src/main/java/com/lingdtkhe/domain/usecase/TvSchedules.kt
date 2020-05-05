package com.lingdtkhe.domain.usecase

import com.lingdtkhe.domain.common.exception.BaseError
import com.lingdtkhe.domain.common.result.Either
import com.lingdtkhe.domain.entities.TvProgram

/**
 * Represent an interface that return any error or tv program schedules
 */
interface TvSchedules {
    suspend fun getTvProgramSchedules(): Either<BaseError, List<TvProgram>>
}