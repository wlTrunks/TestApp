package com.lingdtkhe.data.source.network.server

import com.lingdtkhe.data.common.proceedResponse
import com.lingdtkhe.data.entities.TvProgramData
import com.lingdtkhe.data.source.network.api.NousDigitalApi
import com.lingdtkhe.domain.common.MapperTo
import com.lingdtkhe.domain.common.exception.BaseError
import com.lingdtkhe.domain.common.result.Either
import com.lingdtkhe.domain.entities.TvProgram
import com.lingdtkhe.domain.usecase.TvSchedules

/**
 * Implementation of [TvSchedules]
 */
class TvSchedulesImpl(
    private val api: NousDigitalApi,
    private val mapper: MapperTo<TvProgram, TvProgramData>
) : TvSchedules {
    override suspend fun getTvProgramSchedules(): Either<BaseError, List<TvProgram>> =
        proceedResponse {
            val result = api.getTvSchedules()
            Either.Right(mapper.mapListTo(result.items))
        }
}