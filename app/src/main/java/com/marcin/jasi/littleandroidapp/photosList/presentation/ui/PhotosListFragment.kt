package com.marcin.jasi.littleandroidapp.photosList.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marcin.jasi.littleandroidapp.databinding.PhotosListFragmentBinding
import com.marcin.jasi.littleandroidapp.general.injection.annotation.PerFragment
import com.marcin.jasi.littleandroidapp.general.presentation.common.CommonFragment
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListViewModel

@PerFragment
class PhotosListFragment : CommonFragment<PhotosListViewModel>() {

    lateinit var binding: PhotosListFragmentBinding

    override fun bindData(inflater: LayoutInflater, container: ViewGroup?) {
        binding = PhotosListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
    }

    override fun getRootView(): View {
        return binding.root
    }

    override fun initialize() {
        viewModel.resetHeaderColor()
    }
}