package com.lingdtkhe.testapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lingdtkhe.domain.entities.TvProgram
import com.lingdtkhe.domain.usecase.TvChannelSchedulesUC
import com.lingdtkhe.testapp.common.ui.viewmodel.BaseViewModel
import com.lingdtkhe.testapp.entities.TvProgramVM
import kotlinx.coroutines.delay

class TvSchedulesVM(private val uc: TvChannelSchedulesUC) : BaseViewModel() {

    private val _tvSchedulesLD: MutableLiveData<List<TvProgramVM>> = MutableLiveData()
    val tvSchedulesLD: LiveData<List<TvProgramVM>> = _tvSchedulesLD

    fun getTvSchedules() {
        runOnBackground {
            delay(2000) // just for showing loader
            uc.getTvSchedules().either(::handleError, ::proceedTvSchedule)
        }
    }

    private fun proceedTvSchedule(list: List<TvProgram>) {
        runOnUI {
            _tvSchedulesLD.value =
                list.map { TvProgramVM(it.id, it.title, it.description, it.imageUrl) }
        }
    }
}