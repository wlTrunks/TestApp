package com.lingdtkhe.testapp.ui.fragment

import android.widget.ImageView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.lingdtkhe.testapp.R
import com.lingdtkhe.testapp.common.ui.fragment.BaseFragment
import com.lingdtkhe.testapp.common.util.observeSingle
import com.lingdtkhe.testapp.common.util.positiveButton
import com.lingdtkhe.testapp.common.util.showAlertDialog
import com.lingdtkhe.testapp.databinding.FragmentTvSchedulesBinding
import com.lingdtkhe.testapp.entities.TvProgramVM
import com.lingdtkhe.testapp.ui.adapter.TvProgramAdapter
import com.lingdtkhe.testapp.viewmodels.TvSchedulesVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvSchedulesFragment : BaseFragment<FragmentTvSchedulesBinding>() {

    private val adapter: TvProgramAdapter by lazy { TvProgramAdapter(tvProgramListener) }

    private val tvProgramListener = object : TvProgramAdapter.TvProgramListener {
        override fun onClick(item: TvProgramVM, view: ImageView) {
            proceedOnTvProgram(item, view)
        }
    }

    override val viewModel: TvSchedulesVM by viewModel()

    override fun createLayout(): Int = R.layout.fragment_tv_schedules

    override fun initViews() {
        binding.rvSchedules.adapter = adapter
        viewModel.errorLD.observeSingle(this, {
            requireContext().showAlertDialog(
                messageId =
                R.string.error_title
            ) {
                positiveButton(text = R.string.all_ok)
            }
        })
        viewModel.tvSchedulesLD.observeSingle(this, { adapter.setData(it) })

        viewModel.getTvSchedules()
    }

    private fun proceedOnTvProgram(
        item: TvProgramVM,
        view: ImageView
    ) {
        val extras = FragmentNavigatorExtras(
            view to item.imageUrl
        )
        findNavController().navigate(TvSchedulesFragmentDirections.moveToDetails(item), extras)
    }
}