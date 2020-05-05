package com.lingdtkhe.testapp.common.ui

import androidx.annotation.LayoutRes

interface ViewInit<T> {
    /**
     * @return layout res
     */
    @LayoutRes
    fun createLayout(): Int

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    fun getBindingVariable(): Int

    /**
     * Initialize all view related task
     */
    fun initViews()
}