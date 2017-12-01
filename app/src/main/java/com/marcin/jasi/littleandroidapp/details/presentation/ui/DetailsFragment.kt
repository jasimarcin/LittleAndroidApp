package com.marcin.jasi.littleandroidapp.details.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marcin.jasi.littleandroidapp.databinding.DetailsFragmentBinding
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.DetailsFragmentViewModel
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonFragment


@PerFragment
class DetailsFragment : CommonFragment<DetailsFragmentViewModel>() {

    lateinit var binding: DetailsFragmentBinding

    override fun bindData(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
    }

    override fun getRootView(): View {
        return binding.root
    }

    override fun initialize() {

    }
}