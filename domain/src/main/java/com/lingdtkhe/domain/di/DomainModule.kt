package com.lingdtkhe.domain.di

import com.lingdtkhe.domain.usecase.TvChannelSchedulesUC
import org.koin.dsl.module

/**
 * DI domain module
 */
val DomainModule = module {
    factory { TvChannelSchedulesUC(get()) }
}