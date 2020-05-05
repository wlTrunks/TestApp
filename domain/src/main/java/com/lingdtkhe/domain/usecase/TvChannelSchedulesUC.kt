package com.lingdtkhe.domain.usecase

import com.lingdtkhe.domain.common.exception.BaseError
import com.lingdtkhe.domain.common.result.Either
import com.lingdtkhe.domain.entities.TvProgram

/**
 * This is usecase class for getting for getting tv program list
 * it can be easily covered with unit test [TvChannelSchedulesUCTest]
 */
class TvChannelSchedulesUC(private val repository: TvSchedules) {

    /**
     * Well, for example if item list is empty show some error message
     */
    suspend fun getTvSchedules(): Either<BaseError, List<TvProgram>> =
        when (val result = repository.getTvProgramSchedules()) {
            is Either.Left -> result
            is Either.Right -> if (result.b.isEmpty()) Either.Left(BaseError.FeatureError("List is empty")) else result
        }
}