package com.lingdtkhe.testapp.common.ui.viewmodel

import androidx.annotation.CallSuper
import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.lingdtkhe.domain.common.exception.BaseError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel(), LifecycleMethod {

    protected val superJob: Job = SupervisorJob()

    protected val scope = CoroutineScope(
        superJob + Dispatchers.Default
    )

    val isLoading = ObservableField<Boolean>(false)

    /**
     * Subscribe to show error message
     */
    private val _errorLD: MutableLiveData<String> = MutableLiveData()
    val errorLD: LiveData<String> = _errorLD

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

    /**
     * Func run suspended coroutine in background
     * @param bg body func that needed to run on background
     */
    protected fun <T> runOnBackground(block: suspend CoroutineScope.() -> T): Deferred<T> {
        isLoading.set(true)
        return scope.async(Dispatchers.IO) {
            block()
        }
    }

    /**
     * Func run on UI thread
     * @param front body func that needed to run on UI thread
     */
    protected fun runOnUI(front: suspend CoroutineScope.() -> Unit): Job {
        return scope.launch(Dispatchers.Main) {
            isLoading.set(false)
            front()
        }
    }

    /**
     * Func for handle error response
     * @param error exception
     */
    protected fun handleError(error: BaseError) {
        runOnUI {
            isLoading.set(false)
            _errorLD.value = error.message
        }
    }
}