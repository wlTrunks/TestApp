package com.lingdtkhe.testapp.common.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline onChange: (T) -> Unit) {
    this.observe(owner, Observer<T> { data -> onChange(data) })
}

/**
 * Singles subscriber to livedata, check for any observer
 */
inline fun <T> LiveData<T>.observeSingle(owner: LifecycleOwner, crossinline onChange: (T) -> Unit) {
    if (!this.hasObservers()) this.observe(owner, onChange)
}
