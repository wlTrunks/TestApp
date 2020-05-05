package com.lingdtkhe.data.source.network.server

import com.lingdtkhe.data.entities.TvProgramData
import com.lingdtkhe.domain.common.MapperTo
import com.lingdtkhe.domain.entities.TvProgram

/**
* A mapper that maps a TV program object from a data layer to a domain layer class object
 */
class TvProgramMapper : MapperTo<TvProgram, TvProgramData> {
    override fun mapTo(from: TvProgramData): TvProgram = TvProgram(
        id = from.id,
        title = from.title,
        description = from.description,
        imageUrl = from.imageUrl
    )
}