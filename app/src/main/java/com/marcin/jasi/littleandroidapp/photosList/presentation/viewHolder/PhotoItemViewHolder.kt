package com.marcin.jasi.littleandroidapp.photosList.presentation.viewHolder

import android.databinding.ViewDataBinding
import com.marcin.jasi.littleandroidapp.databinding.PhotosListRowBinding
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonViewModel
import com.marcin.jasi.littleandroidapp.general.presentation.viewHolder.BaseRecyclerViewHolder
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListItemViewModel

class PhotoItemViewHolder(val binding: PhotosListRowBinding) : BaseRecyclerViewHolder<ViewDataBinding, CommonViewModel>(binding) {

    override fun bind(viewModel: CommonViewModel) {
        binding.viewModel = viewModel as PhotosListItemViewModel
    }

}

