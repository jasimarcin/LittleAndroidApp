package com.marcin.jasi.littleandroidapp.general.injection.module

import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.DetailsFragmentViewModel
import com.marcin.jasi.littleandroidapp.details.presentation.viewModel.DetailsFragmentViewModelImpl
import com.marcin.jasi.littleandroidapp.main.presentation.viewModel.MainActivityViewModel
import com.marcin.jasi.littleandroidapp.main.presentation.viewModel.MainActivityViewModelImpl
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListViewModel
import com.marcin.jasi.littleandroidapp.photosList.presentation.viewModel.PhotosListViewModelImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelBindingModule {

    @Binds
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModelImpl): MainActivityViewModel

    @Binds
    abstract fun bindDetailsFragmentViewModel(viewModel: DetailsFragmentViewModelImpl): DetailsFragmentViewModel

    @Binds
    abstract fun bindPhotosListFragmentViewModel(viewModel: PhotosListViewModelImpl): PhotosListViewModel

}