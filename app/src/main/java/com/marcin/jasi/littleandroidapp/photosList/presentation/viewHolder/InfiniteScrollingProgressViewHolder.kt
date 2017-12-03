package com.marcin.jasi.littleandroidapp.photosList.presentation.viewHolder

import android.databinding.ViewDataBinding
import com.marcin.jasi.littleandroidapp.databinding.RowProgressBarBinding
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.viewHolder.BaseRecyclerViewHolder
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.InfiniteScrollingProgressViewModel

class InfiniteScrollingProgressViewHolder(var binding: RowProgressBarBinding)
    : BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>(binding) {

    override fun bind(viewModel: CommonViewModel) {
        binding.viewModel = viewModel as InfiniteScrollingProgressViewModel?
    }
}