package com.marcin.jasi.littleandroidapp.details.presentation.viewHolder

import android.databinding.ViewDataBinding
import com.marcin.jasi.littleandroidapp.databinding.PercentageRowBinding
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.PercentageItemViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.viewHolder.BaseRecyclerViewHolder

class PercentageItemVIewHolder(val binding: PercentageRowBinding) : BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>(binding) {

    override fun bind(viewModel: CommonViewModel) {
        binding.viewModel = viewModel as PercentageItemViewModel
    }

}