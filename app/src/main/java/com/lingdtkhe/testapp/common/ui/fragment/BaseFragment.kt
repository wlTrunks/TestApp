package com.lingdtkhe.testapp.common.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import com.lingdtkhe.testapp.common.ui.viewmodel.BaseViewModel

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    /**
     * @return layout res
     */
    @LayoutRes
    protected abstract fun createLayout(): Int

    /**
     * Initialize all view related task
     */
    protected abstract fun initViews()

    protected abstract val viewModel: BaseViewModel

    protected lateinit var binding: T

    private fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, createLayout(), container, false)
        return with(binding) {
            setVariable(getBindingVariable(), viewModel)
            executePendingBindings()
            lifecycleOwner = this@BaseFragment
            root
        }
    }
}