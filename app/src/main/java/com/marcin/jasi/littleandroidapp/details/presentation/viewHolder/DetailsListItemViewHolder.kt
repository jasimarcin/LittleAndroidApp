package com.marcin.jasi.littleandroidapp.details.presentation.viewHolder

import android.databinding.ViewDataBinding
import com.marcin.jasi.littleandroidapp.databinding.DetailsRowBinding
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.DetailsItemViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.viewHolder.BaseRecyclerViewHolder

class DetailsListItemViewHolder(val binding: DetailsRowBinding) : BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>(binding) {

    override fun bind(viewModel: CommonViewModel) {
        binding.viewModel = viewModel as DetailsItemViewModel
    }

}
