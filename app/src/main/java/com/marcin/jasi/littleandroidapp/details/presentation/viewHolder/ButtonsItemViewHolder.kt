package com.marcin.jasi.littleandroidapp.details.presentation.viewHolder

import android.databinding.ViewDataBinding
import com.marcin.jasi.littleandroidapp.databinding.ButtonsRowBinding
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.ButtonsItemViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.viewHolder.BaseRecyclerViewHolder

class ButtonsItemViewHolder(val binding: ButtonsRowBinding) : BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>(binding) {

    override fun bind(viewModel: CommonViewModel) {
        binding.viewModel = viewModel as ButtonsItemViewModel
    }

}