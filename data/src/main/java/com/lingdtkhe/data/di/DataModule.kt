package com.lingdtkhe.data.di

import com.lingdtkhe.data.common.Network.provideNousDigitalApi
import com.lingdtkhe.data.entities.TvProgramData
import com.lingdtkhe.data.source.network.server.TvProgramMapper
import com.lingdtkhe.data.source.network.server.TvSchedulesImpl
import com.lingdtkhe.domain.common.MapperTo
import com.lingdtkhe.domain.entities.TvProgram
import com.lingdtkhe.domain.usecase.TvSchedules
import org.koin.dsl.module

/**
 * DI data module
 */
val DataModule = module {

    single { provideNousDigitalApi() }
    single<MapperTo<TvProgram, TvProgramData>> { TvProgramMapper() }
    single<TvSchedules> { TvSchedulesImpl(get(), get()) }
}