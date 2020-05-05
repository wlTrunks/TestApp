package com.lingdtkhe.testapp.ui.fragment

import android.os.Bundle
import androidx.core.app.ShareCompat
import androidx.transition.TransitionInflater
import com.lingdtkhe.testapp.R
import com.lingdtkhe.testapp.common.ui.fragment.BaseFragment
import com.lingdtkhe.testapp.common.util.loadImage
import com.lingdtkhe.testapp.databinding.FragmentTvProgramDetailsBinding
import com.lingdtkhe.testapp.entities.TvProgramVM
import com.lingdtkhe.testapp.viewmodels.TvProgramDetailsVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvProgramDetailsFragment : BaseFragment<FragmentTvProgramDetailsBinding>() {

    override val viewModel: TvProgramDetailsVM by viewModel()

    override fun createLayout(): Int = R.layout.fragment_tv_program_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun initViews() {
        binding.ivShare.setOnClickListener { shareTvProgram() }
        arguments?.getParcelable<TvProgramVM>(ARG_TV_PROGRAM)?.let {
            viewModel.tvProgram = it
            with(binding) {
                tvTitle.text = it.title
                tvDescription.text = it.description
                ivFullImage.loadImage(it.imageUrl)
            }
        }
    }

    private fun shareTvProgram() {
        viewModel.tvProgram?.run {
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setSubject("Check this awesome program")
                .setText(getEmailBody())
                .setType("message/rfc822")
                .setChooserTitle("Send email by")
                .startChooser()
        }
    }

    companion object {
        private const val ARG_TV_PROGRAM = "tv_program"
    }
}