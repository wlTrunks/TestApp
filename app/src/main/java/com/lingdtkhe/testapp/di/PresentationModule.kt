package com.lingdtkhe.testapp.di

import com.lingdtkhe.testapp.viewmodels.TvProgramDetailsVM
import com.lingdtkhe.testapp.viewmodels.TvSchedulesVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * DI presentation module
 */
val PresentationModule = module {
    viewModel { TvSchedulesVM(get()) }
    viewModel { TvProgramDetailsVM() }
}