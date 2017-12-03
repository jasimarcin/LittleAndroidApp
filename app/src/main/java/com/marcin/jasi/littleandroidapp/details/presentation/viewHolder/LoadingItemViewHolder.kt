package com.marcin.jasi.littleandroidapp.details.presentation.viewHolder

import android.databinding.ViewDataBinding
import com.marcin.jasi.littleandroidapp.databinding.LoadingRowBinding
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.LoadingItemViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.viewHolder.BaseRecyclerViewHolder

class LoadingItemViewHolder (val binding: LoadingRowBinding) : BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>(binding) {

    override fun bind(viewModel: CommonViewModel) {
        binding.viewModel = viewModel as LoadingItemViewModel
    }

}