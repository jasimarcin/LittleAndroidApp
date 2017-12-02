package com.marcin.jasi.littleandroidapp.photosList.presentation.viewHolder

import android.support.v7.widget.RecyclerView
import com.marcin.jasi.littleandroidapp.databinding.PhotosListRowBinding
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListItemViewModel

class PhotoItemViewHolder(val binding: PhotosListRowBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: PhotosListItemViewModel) {
        binding.viewModel = viewModel
    }
}

